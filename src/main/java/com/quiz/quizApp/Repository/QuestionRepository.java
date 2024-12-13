package com.quiz.quizApp.Repository;

import com.quiz.quizApp.Entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
