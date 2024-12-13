package com.quiz.quizApp.Repository;

import com.quiz.quizApp.Entity.QuizSession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizSessionRepository extends JpaRepository<QuizSession, Long> {
}
