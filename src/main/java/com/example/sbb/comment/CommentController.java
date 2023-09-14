package com.example.sbb.comment;

import com.example.sbb.answer.Answer;
import com.example.sbb.answer.AnswerForm;
import com.example.sbb.answer.AnswerService;
import com.example.sbb.question.Question;
import com.example.sbb.question.QuestionService;
import com.example.sbb.user.SiteUser;
import com.example.sbb.user.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.List;
import java.util.Map;

@RequestMapping("/comment")
@RequiredArgsConstructor
@Controller
public class CommentController {
    private final AnswerService answerService;
    private final QuestionService questionService;
    private final UserService userService;
    private final CommentService commentService;

    /*
    list
    /create/{id}
    /modify/{id}
    /delete/{id}
    /vote/{id}
     */
    @PreAuthorize("isAuthenticated()")
    @PostMapping("/create/{id}")
    public String createComment(Model model, @PathVariable("id") Integer id, @Valid CommentForm commentForm, BindingResult bindingResult, Principal principal) {
        Answer answer = this.answerService.getAnswer(id);
        SiteUser siteUser = this.userService.getUser(principal.getName());
        if (bindingResult.hasErrors()) {
            model.addAttribute("answer", answer);
            return "question_detail";
        }
        this.commentService.create(answer, commentForm.getComment(), siteUser);
        return String.format("redirect:/question/detail/%s#answer_%s",
                answer.getQuestion().getId(), answer.getId());
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/modify/{id}")
    public String commentModify(@Valid CommentForm commentForm,
                                @PathVariable("id") Integer id,
                                @AuthenticationPrincipal UserDetails userDetails) {
        Comment comment = this.commentService.getComment(id);
        if (userDetails.getUsername().equals(comment.getAuthor().getUsername()) || userDetails.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) {
            commentForm.setComment(comment.getComment());
            return "comment_form";
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정권한이 없습니다.");
        }
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/modify/{id}")
    public String commentModify(@Valid CommentForm commentForm,
                                @PathVariable("id") Integer id,
                                BindingResult bindingResult,
                                @AuthenticationPrincipal UserDetails userDetails) {
        if (bindingResult.hasErrors()) {
            return "comment_form";
        }
        Comment comment = this.commentService.getComment(id);
        if (userDetails.getUsername().equals(comment.getAuthor().getUsername()) || userDetails.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) {
            this.commentService.modify(comment, commentForm.getComment());
            return String.format("redirect:/question/detail/%s#comment_%s", comment.getAnswer().getQuestion().getId(), comment.getId());
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정권한이 없습니다.");
        }
    }


    @PreAuthorize("isAuthenticated()")
    @GetMapping("/delete/{id}")
    public String commentDelete(@PathVariable("id") Integer id, @AuthenticationPrincipal UserDetails userDetails) {
        Comment comment = this.commentService.getComment(id);

        if (userDetails.getUsername().equals(comment.getAuthor().getUsername()) || userDetails.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) {
            // 현재 사용자가 질문 작성자거나 관리자인 경우에만 삭제 허용
            this.commentService.delete(comment);
            return String.format("redirect:/question/detail/%s", comment.getAnswer().getQuestion().getId());
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "삭제권한이 없습니다.");
        }
    }

    @ResponseBody
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/vote/{id}")
    public ResponseEntity<Map<String, Object>> commentVote(Principal principal, @PathVariable("id") Integer id) {
        Comment comment = this.commentService.getComment(id);
        SiteUser siteUser = this.userService.getUser(principal.getName());

        // 이미 해당 사용자가 이 답변을 추천한 경우, JSON 응답으로 메시지 반환
        if (comment.getVoter().contains(siteUser)) {
            return ResponseEntity.ok(Map.of("alreadyVoted", true, "updatedCount", comment.getVoter().size()));
        }

        this.commentService.vote(comment, siteUser);
        return ResponseEntity.ok(Map.of("alreadyVoted", false, "updatedCount", comment.getVoter().size()));
    }
}
