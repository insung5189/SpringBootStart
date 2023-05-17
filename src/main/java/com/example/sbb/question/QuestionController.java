package com.example.sbb.question;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import com.example.sbb.answer.AnswerForm;

import java.util.List;
@RequiredArgsConstructor
@Controller
@RequestMapping("/question")
public class QuestionController {
    private final QuestionRepository questionRepository;
    private final QuestionService questionService;
    @GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id, AnswerForm answerForm) {
        Question question = this.questionService.getQuestion(id);
        model.addAttribute("question", question);
        return "question_detail";
    }

    @GetMapping("/list")
    public String list(Model model, @RequestParam(value="page", defaultValue="1") int page) { // url에 page내용이 없을땐 0값을 기본값으로 설정해라.
        if (page == 0) { // 페이지넘버가 0일때 page=1로 리디렉션 하라는 if문
            return "redirect:/question/list?page=1";
        }
        Page<Question> paging = this.questionService.getList(page);
        model.addAttribute("paging", paging);
        List<Question> questionList = this.questionService.getList(); // 컨트롤러에서 바로 QuestionRepository 로 가던 구조를 중간에 Service 를 만들어서 거쳐가게끔 만듬.
        model.addAttribute("questionList", questionList);
        return "question_list"; // resources 예하 templates 예하 question_list HTML 파일로 인식해서 브라우저에 띄워줌
    }
    @GetMapping("/create") // get == 가져오다
    public String questionCreate(QuestionForm questionForm) {
        return "question_form";
    }

    @PostMapping("/create") // post == 보내다
    public String questionCreate(@Valid QuestionForm questionForm, BindingResult bindingResult) {
        // TODO 질문을 저장한다.
        // (주석으로 "TODO" 를 달아놓으면 인텔리제이에서 인지해서 만약 계획된 TODO 에 관련된 로직이 작성이 안되면 커밋할때 한 번더 물어봐준다)
        if (bindingResult.hasErrors()) {
            return "question_form";
        }
        this.questionService.create(questionForm.getSubject(), questionForm.getContent());
        return "redirect:/question/list"; // 질문 저장후 질문목록으로 이동
    }
}