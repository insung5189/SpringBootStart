package com.example.sbb.question;


import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.domain.Sort;
import com.example.sbb.DataNotFoundException;

@Data
@RequiredArgsConstructor // 자동으로 생성자함수 초기화(여기에선 questionRepository)
@Service
public class QuestionService {
    private final QuestionRepository questionRepository; // final을 사용하는 이유는 최적화의 목적

    public List<Question> getList () {
        return this.questionRepository.findAll();
    }

    public Question getQuestion(Integer id) {// Integer 로 타입이 들어오면 null 값도 허용해줄 수 있음
        Optional<Question> question = this.questionRepository.findById(id);
        if (question.isPresent()) {
            return question.get();
        } else {
            throw new DataNotFoundException("question not found"); // 예외처리로 에러(DataNotFoundException)를 표시
        }
    }

    public void create(String subject, String content) {
        Question q = new Question();
        q.setSubject(subject);
        q.setContent(content);
        q.setCreateDate(LocalDateTime.now());
        this.questionRepository.save(q);
    }
    public Page<Question> getList(int page) {
        List<Sort.Order> sorts = new ArrayList<>();
        sorts.add(Sort.Order.desc("createDate"));
        Pageable pageable = PageRequest.of(page-1, 10, Sort.by(sorts)); // 애초에 불러온 페이지넘버의 -1한 페이지를 불러오고 HTML에서 미루어 처리
        return this.questionRepository.findAll(pageable);
    }



}
