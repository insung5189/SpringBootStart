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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

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
        // TODO: 답변을 저장한다.
        SiteUser siteUser = this.userService.getUser(principal.getName());
        if (bindingResult.hasErrors()) {
            model.addAttribute("answer", answer);
            return "question_detail";
        }
        Comment comment = this.commentService.create(answer,
                commentForm.getComment(), siteUser);
        return String.format("redirect:/question/detail/%s#answer_%s",
                comment.getAnswer().getId(), comment.getId());
    }
}
