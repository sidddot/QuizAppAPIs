package com.quiz.quizApp.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class QuizSummaryDTO {
    private int totalQuestions;
    private int correctAnswers;
    private int incorrectAnswers;
    private List<Long> answeredQuestionIds;
}
