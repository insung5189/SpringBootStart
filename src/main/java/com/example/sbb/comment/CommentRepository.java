package com.example.sbb.comment;

import com.example.sbb.answer.Answer;
import com.example.sbb.question.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

}
