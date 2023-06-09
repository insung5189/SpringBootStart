package com.example.sbb.answer;

import com.example.sbb.comment.Comment;
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
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // pk속성 부여
    private Integer id; // PK, Answer테이블의 id값

    @Column(columnDefinition = "TEXT") // TEXT 자료형으로 부여
    private String content; // Answer테이블의 내용 칼럼

    private LocalDateTime createDate; // Answer테이블의 작성일 칼럼

    @ManyToOne // Answer기준에서는 ManyToOne입장이라 이렇게 어노테이션 달아줌.
    private Question question; // Question 테이블의 FK값
    // SHOW COLUMNS FROM answer;
    @ManyToOne
    private SiteUser author;
    private LocalDateTime modifyDate;
    @OneToMany(mappedBy = "answer", cascade = CascadeType.REMOVE) // 참조속성으로 걸어둠(객체화 하면 알아서 SQL 쿼리문으로 작성해줌.)
    private List<Comment> commentList; // CommentService에서 getList만들어야함.
    @ManyToMany
    Set<SiteUser> voter;
}
