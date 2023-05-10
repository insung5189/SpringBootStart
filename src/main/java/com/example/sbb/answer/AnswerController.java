package com.example.sbb.answer;

import com.example.sbb.question.Question;
import com.example.sbb.question.QuestionService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;

import java.util.List;

@Data // 이걸 붙이면 웬만한 데이터들은 다 들어옴
@RequestMapping("/answer")
@RequiredArgsConstructor // 변수를 포함하는 생성자를 자동으로 생성.
@Controller
public class AnswerController {
    private final AnswerService answerService;
    private final QuestionService questionService;
    @GetMapping("/list")
    public String list (Model model) {
        List<Answer> answerList = this.answerService.getList(); // 컨트롤러에서 바로 AnswerRepository 로 가던 구조를 중간에 Service 를 만들어서 거쳐가게끔 만듬.
        model.addAttribute("answerList", answerList);
        return "answer_list"; // resources 예하 templates 예하 answer_list HTML 파일로 인식해서 브라우저에 띄워줌
    }
    @GetMapping("/detail/{id}")
    public String detail (Model model, @PathVariable("id") Integer aid, @PathVariable("id") Integer qid) { // @PathVariable을 사용해서 경로형 변수 id값을 받아온다 라고 생각하면 됨.
        Answer answer = this.answerService.getAnswer(aid); // id >> aid
        Question question = this.questionService.getQuestion(qid); // 추가 id >> qid
        model.addAttribute("question", question); // 추가
        model.addAttribute("answer", answer);
        return "answer_detail"; // answer_detail html 파일로 연결해줌.
    }
    @PostMapping("/create/{id}")
    public String createAnswer(Model model, @PathVariable("id") Integer id, @Valid AnswerForm answerForm, BindingResult bindingResult) {
        Question question = this.questionService.getQuestion(id);
        // TODO: 답변을 저장한다.
        if (bindingResult.hasErrors()) {
            model.addAttribute("question", question);
            return "question_detail";
        }
        this.answerService.create(question, answerForm.getContent());
        return String.format("redirect:/question/detail/%s", id);
    }
}
