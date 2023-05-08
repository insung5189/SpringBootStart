package com.example.sbb.question;

import com.example.sbb.question.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
    // QuestionRepository를 리포지터리로 만들기 위해서 JpaRepository를 상속받고 제네릭스 형태로 엔티티의 타입(Question)과 해당 PK의 속성타입(Integer)을 지정해주어야 한다.
    Question findBySubject(String subject); // findBySubject메서드는 JpaRepository의 내장메서드가 아니기 때문에 직접 만들어줘야 한다.
    // 제목으로 해당 엔티티의 튜플을 검색할 수 있다.
    Question findBySubjectAndContent(String subject, String content); // findBySubjectAndContent 역시 JpaRepository의 내장메서드가 아니기 때문에 직접 만들어줘야 한다.
    // 제목과 내용이 일치하는 튜플을 검색할 수 있다.
    List<Question> findBySubjectLike(String subject);

}

//https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.limit-query-result