package com.example.sbb.comment;

import com.example.sbb.answer.Answer;
import com.example.sbb.question.Question;
import com.example.sbb.user.SiteUser;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment 기능 추가
    private Integer id;
    @Column(columnDefinition = "TEXT") // TEXT 자료형으로 부여
    private String comment; // Answer테이블의 내용 칼럼
    private LocalDateTime createDate; // Comment테이블의 작성일 칼럼
    @ManyToOne // Comment기준에서는 ManyToOne입장이라 이렇게 어노테이션 달아줌.
    private Answer answer; // Answer 테이블의 FK값
    @ManyToOne
    private SiteUser author;
    private LocalDateTime modifyDate;
    @ManyToMany
    Set<SiteUser> voter;
    // comment, createDate, answer33, author1.
}
