package com.quiz.quizApp.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnswerResponseDTO {
    private boolean correct;
    private String correctAnswer;
}
