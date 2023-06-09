package com.example.sbb.question;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
    // QuestionRepository를 리포지터리로 만들기 위해서 JpaRepository를 상속받고 제네릭스 형태로 엔티티의 타입(Question)과 해당 PK의 속성타입(Integer)을 지정해주어야 한다.
    Question findBySubject(String subject); // findBySubject메서드는 JpaRepository의 내장메서드가 아니기 때문에 직접 만들어줘야 한다.
    // 제목으로 해당 엔티티의 튜플을 검색할 수 있다.
    Question findBySubjectAndContent(String subject, String content); // findBySubjectAndContent 역시 JpaRepository의 내장메서드가 아니기 때문에 직접 만들어줘야 한다.
    // 제목과 내용이 일치하는 튜플을 검색할 수 있다.
    List<Question> findBySubjectLike(String subject);
    Page<Question> findAll(Pageable pageable); // 모든 데이터를 받아올 건데 자바 스프링에서 기본제공해주는 형태를 참조해서 가져올것이다.
    Page<Question> findAll(Specification<Question> spec, Pageable pageable);
    @Query("select "
            + "distinct q "
            + "from Question q "
            + "left outer join SiteUser u1 on q.author=u1 "
            + "left outer join Answer a on a.question=q "
            + "left outer join SiteUser u2 on a.author=u2 "
            + "where "
            + "   q.subject like %:kw% "
            + "   or q.content like %:kw% "
            + "   or u1.username like %:kw% "
            + "   or a.content like %:kw% "
            + "   or u2.username like %:kw% ")
    Page<Question> findAllByKeyword(@Param("kw") String kw, Pageable pageable);
}

//https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.limit-query-result