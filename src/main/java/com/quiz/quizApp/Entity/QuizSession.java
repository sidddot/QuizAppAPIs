package com.quiz.quizApp.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class QuizSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;
    private int correctAnswers = 0;
    private int incorrectAnswers = 0;

    @ElementCollection
    private List<Long> answeredQuestions = new ArrayList<>();
}
