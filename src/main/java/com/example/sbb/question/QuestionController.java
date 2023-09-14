package com.example.sbb.question;

import com.example.sbb.answer.Answer;
import com.example.sbb.answer.AnswerService;
import com.example.sbb.comment.Comment;
import com.example.sbb.comment.CommentForm;
import com.example.sbb.comment.CommentRepository;
import com.example.sbb.user.SiteUser;
import com.example.sbb.user.UserService;
import lombok.*;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import com.example.sbb.answer.AnswerForm;
import org.springframework.web.server.ResponseStatusException;
import lombok.extern.slf4j.*;

import java.security.Principal;
import java.util.List;
import java.util.Map;

//@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/question")
public class QuestionController {
    private final QuestionService questionService;
    private final AnswerService answerService;
    private final UserService userService;
    private final QuestionRepository questionRepository;
    private final CommentRepository commentRepository;

    @GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id, AnswerForm answerForm, CommentForm commentForm, Principal principal) {
        Question question = this.questionService.getQuestion(id);
        List<Answer> answerList = this.answerService.getAnswersForQuestion(id);
        model.addAttribute("answerList", answerList); // 모든 답변을 리스트로 추가
        model.addAttribute("question", question);
        return "question_detail";
    }

    @GetMapping("/list")
    public String list(Model model,
                       @RequestParam(value = "page", defaultValue = "1") int page,
                       @RequestParam(value = "kw", defaultValue = "") String kw) { // url에 page내용이 없을땐 0값을 기본값으로 설정해라.
        if (page == 0) { // 페이지넘버가 0일때 page=1로 리디렉션 하라는 if문
            return "redirect:/question/list?page=1";
        }
        Page<Question> paging = this.questionService.getList(page, kw);
        model.addAttribute("paging", paging);
        model.addAttribute("kw", kw);

        List<Question> questionList = this.questionService.getList();// 컨트롤러에서 바로 QuestionRepository 로 가던 구조를 중간에 Service 를 만들어서 거쳐가게끔 만듬.
        model.addAttribute("questionList", questionList);
        return "question_list"; // resources 예하 templates 예하 question_list HTML 파일로 인식해서 브라우저에 띄워줌
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/create") // get == 가져오다
    public String questionCreate(QuestionForm questionForm) {
        return "question_form";
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/create") // post == 보내다
    public String questionCreate(@Valid QuestionForm questionForm, BindingResult bindingResult, Principal principal) {
        // TODO 질문을 저장한다.
        // (주석으로 "TODO" 를 달아놓으면 인텔리제이에서 인지해서 만약 계획된 TODO 에 관련된 로직이 작성이 안되면 커밋할때 한 번더 물어봐준다)
        if (bindingResult.hasErrors()) {
            return "question_form";
        }
        SiteUser siteUser = this.userService.getUser(principal.getName());
        this.questionService.create(questionForm.getSubject(), questionForm.getContent(), siteUser);
        return "redirect:/question/list"; // 질문 저장후 질문목록으로 이동
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/modify/{id}")
    public String questionModify(QuestionForm questionForm, @PathVariable("id") Integer id, @AuthenticationPrincipal UserDetails userDetails) {
        Question question = this.questionService.getQuestion(id);
        if (userDetails.getUsername().equals(question.getAuthor().getUsername()) || userDetails.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) {
            questionForm.setSubject(question.getSubject());
            questionForm.setContent(question.getContent());
            return "question_form";
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정권한이 없습니다.");
        }
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/modify/{id}")
    public String questionModify(@Valid QuestionForm questionForm, BindingResult bindingResult,
                                 @AuthenticationPrincipal UserDetails userDetails, @PathVariable("id") Integer id) {
        if (bindingResult.hasErrors()) {
            return "question_form";
        }
        Question question = this.questionService.getQuestion(id);
        if (userDetails.getUsername().equals(question.getAuthor().getUsername()) || userDetails.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) {
            this.questionService.modify(question, questionForm.getSubject(), questionForm.getContent());
            return String.format("redirect:/question/detail/%s", id);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정권한이 없습니다.");
        }
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/delete/{id}")
    public String questionDelete(@AuthenticationPrincipal UserDetails userDetails, @PathVariable("id") Integer id) {
        Question question = this.questionService.getQuestion(id);

        if (userDetails.getUsername().equals(question.getAuthor().getUsername()) || userDetails.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) {
            // 현재 사용자가 질문 작성자거나 관리자인 경우에만 삭제 허용
            this.questionService.delete(question);
            return "redirect:/";
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "삭제권한이 없습니다.");
        }
    }

    @ResponseBody
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/vote/{id}")
    public ResponseEntity<?> questionVote(Principal principal, @PathVariable("id") Integer id) {
        Question question = this.questionService.getQuestion(id);
        SiteUser siteUser = this.userService.getUser(principal.getName());

        // 이미 해당 사용자가 이 질문을 추천한 경우, JSON 응답으로 메시지 반환
        if (question.getVoter().contains(siteUser)) {
            return ResponseEntity.ok(Map.of("alreadyVoted", true));
        }

        this.questionService.vote(question, siteUser);

        // 업데이트된 추천 수를 반환
        int updatedCount = question.getVoter().size();
        return ResponseEntity.ok(Map.of("alreadyVoted", false, "updatedCount", updatedCount));
    }


}