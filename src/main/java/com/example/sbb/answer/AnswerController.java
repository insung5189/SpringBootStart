package com.example.sbb.answer;

import com.example.sbb.comment.CommentForm;
import com.example.sbb.question.Question;
import com.example.sbb.question.QuestionService;
import com.example.sbb.user.SiteUser;
import com.example.sbb.user.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.List;

@RequestMapping("/answer")
@RequiredArgsConstructor // 변수를 포함하는 생성자를 자동으로 생성.
@Controller
public class AnswerController {
    private final AnswerService answerService;
    private final QuestionService questionService;
    private final UserService userService;
    @GetMapping("/list")
    public String list (Model model) {
        List<Answer> answerList = this.answerService.getList(); // 컨트롤러에서 바로 AnswerRepository 로 가던 구조를 중간에 Service 를 만들어서 거쳐가게끔 만듬.
        model.addAttribute("answerList", answerList);
        return "answer_list"; // resources 예하 templates 예하 answer_list HTML 파일로 인식해서 브라우저에 띄워줌
    }
    @GetMapping("/detail/{id}")
    public String detail (Model model, @PathVariable("id") Integer aid, Integer qid) { // @PathVariable을 사용해서 경로형 변수 id값을 받아온다 라고 생각하면 됨.
        Answer answer = this.answerService.getAnswer(aid); // id >> aid
        Question question = this.questionService.getQuestion(qid); // 추가 id >> qid
//        model.addAttribute("question", question); // 추가
        model.addAttribute("answer", answer);
        return "answer_detail"; // answer_detail html 파일로 연결해줌.
    }


    @PreAuthorize("isAuthenticated()")
    @PostMapping("/create/{id}")
    public String createAnswer(Model model, @PathVariable("id") Integer id, @Valid AnswerForm answerForm, BindingResult bindingResult, Principal principal) {
        Question question = this.questionService.getQuestion(id);
        // TODO: 답변을 저장한다.
        SiteUser siteUser = this.userService.getUser(principal.getName());
        if (bindingResult.hasErrors()) {
            model.addAttribute("question", question);
            return "question_detail";
        }
        Answer answer = this.answerService.create(question,
                answerForm.getContent(), siteUser);
        return String.format("redirect:/question/detail/%s#answer_%s",
                answer.getQuestion().getId(), answer.getId());
    }


    //호현코드
//    @PreAuthorize("isAuthenticated()")
//    @PostMapping("/create/{id}/{sortKeyWord}/{page}") // form 태그 method="post"로 요청되므로
//    public String createAnswer(Model model, @PathVariable("id") Integer id, @PathVariable("page") int page, @Valid AnswerForm answerForm, BindingResult bindingResult, Principal principal) { // 요청 시 들어가는 데이터는 @RequestParam 으로
//        // 답변을 저장할 질문 객체 불러옴
//        Question question = this.questionService.getQuestion(id);
//        SiteUser author = this.userService.getUser(principal.getName());
//        // 답변 입력 validation 통과 못했을 경우 question_detail 템플릿을 다시 렌더링
//        if (bindingResult.hasErrors()) {
//            model.addAttribute("question", question); // 질문 상세를 출력해야 하므로 model 객체로 질문을 전달한다
//            model.addAttribute("commentForm", new CommentForm());
//            return "question_detail";
//        }
//        // 답변 저장
//        Answer answer = this.answerService.create(question, answerForm.getContent(), author);
//        // 답변 저장 완료 후, 기존에 있었던 질문 상세 페이지로 리턴
//        return String.format("redirect:/question/detail/%s?page=%s#answer_%s",
//                answer.getQuestion().getId(), page, answer.getId());
//    }




    @PreAuthorize("isAuthenticated()")
    @GetMapping("/modify/{id}")
    public String answerModify(AnswerForm answerForm, @PathVariable("id") Integer id, Principal principal) {
        Answer answer = this.answerService.getAnswer(id);
        if (!answer.getAuthor().getUsername().equals(principal.getName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정권한이 없습니다.");
        }
        answerForm.setContent(answer.getContent());
        return "answer_form";
    }
    @PreAuthorize("isAuthenticated()")
    @PostMapping("/modify/{id}")
    public String answerModify(@Valid AnswerForm answerForm, @PathVariable("id") Integer id,
                               BindingResult bindingResult, Principal principal) {
        if (bindingResult.hasErrors()) {
            return "answer_form";
        }
        Answer answer = this.answerService.getAnswer(id);
        if (!answer.getAuthor().getUsername().equals(principal.getName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정권한이 없습니다.");
        }
        this.answerService.modify(answer, answerForm.getContent());
        return String.format("redirect:/question/detail/%s#answer_%s",
                answer.getQuestion().getId(), answer.getId());
    }
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/delete/{id}")
    public String answerDelete(Principal principal, @PathVariable("id") Integer id) {
        Answer answer = this.answerService.getAnswer(id);
        if (!answer.getAuthor().getUsername().equals(principal.getName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "삭제권한이 없습니다.");
        }
        this.answerService.delete(answer);
        return String.format("redirect:/question/detail/%s", answer.getQuestion().getId());
    }
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/vote/{id}")
    public String answerVote(Principal principal, @PathVariable("id") Integer id) {
        Answer answer = this.answerService.getAnswer(id);
        SiteUser siteUser = this.userService.getUser(principal.getName());
        this.answerService.vote(answer, siteUser);
        return String.format("redirect:/question/detail/%s#answer_%s",
                answer.getQuestion().getId(), answer.getId());
    }
}
