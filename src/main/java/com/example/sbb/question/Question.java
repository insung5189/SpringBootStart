package com.example.sbb.question;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import com.example.sbb.answer.Answer;
import com.example.sbb.user.SiteUser;
import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment 기능 추가
    private Integer id;

    @Column(length = 200) // 자료의 길이.(제목으로 쓰일 내용의 길이)
    private String subject;

    @Column(columnDefinition = "TEXT") // 텍스트 자료형
    private String content;

    private LocalDateTime createDate; // 지금현재 정의한 로컬타임의 현재시간
    // SHOW COLUMNS FROM question;
    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE) // 질문 한 개당 답변은 여러 개일 수 있기 때문에 OneToMany를 사용
    // 참조속성으로 걸어둠(객체화 하면 알아서 SQL 쿼리문으로 작성해줌.)
    // 질문이 없는 답변은 의미가 없기때문에 질문이 삭제되면 알아서 답변까지 삭제되게 외래키를 규정해줌.
    private List<Answer> answerList;
    @ManyToOne
    private SiteUser author; // 질문 여러 개가 작성자 한 명이 작성 한 것일 수 있기 때문에 ManyToOne을 사용한다
    private LocalDateTime modifyDate;
    @ManyToMany
    Set<SiteUser> voter;

    @Column(columnDefinition = "integer default 0", nullable = false)
    private int view;
}
