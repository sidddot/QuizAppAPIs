package com.quiz.quizApp.Service;

import com.quiz.quizApp.DTO.*;
import com.quiz.quizApp.Entity.*;
import com.quiz.quizApp.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// import java.util.Optional;
import java.util.Random;

@Service
public class QuizService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private QuizSessionRepository quizSessionRepository;

    public QuizSession startQuiz(String userId) {
        QuizSession session = new QuizSession();
        session.setUserId(userId);
        return quizSessionRepository.save(session);
    }

    public QuestionDTO getRandomQuestion(Long sessionId) {
        QuizSession session = quizSessionRepository.findById(sessionId)
                .orElseThrow(() -> new RuntimeException("Session not found"));

        long questionCount = questionRepository.count();
        if (session.getAnsweredQuestions().size() >= questionCount) {
            throw new RuntimeException("No more questions available");
        }

        Random random = new Random();
        Question question;
        do {
            long randomId = random.nextLong(questionCount) + 1;
            question = questionRepository.findById(randomId).orElse(null);
        } while (question == null || session.getAnsweredQuestions().contains(question.getId()));

        session.getAnsweredQuestions().add(question.getId());
        quizSessionRepository.save(session);

        QuestionDTO dto = new QuestionDTO();
        dto.setId(question.getId());
        dto.setQuestion(question.getQuestion());
        dto.setOptionA(question.getOptionA());
        dto.setOptionB(question.getOptionB());
        dto.setOptionC(question.getOptionC());
        dto.setOptionD(question.getOptionD());
        return dto;
    }

    public AnswerResponseDTO submitAnswer(Long sessionId, Long questionId, String answer) {
        QuizSession session = quizSessionRepository.findById(sessionId)
                .orElseThrow(() -> new RuntimeException("Session not found"));

        Question question = questionRepository.findById(questionId)
                .orElseThrow(() -> new RuntimeException("Question not found"));

        boolean correct = question.getCorrectAnswer().equalsIgnoreCase(answer);
        if (correct) {
            session.setCorrectAnswers(session.getCorrectAnswers() + 1);
        } else {
            session.setCorrectAnswers(session.getCorrectAnswers() + 1);
        }
        quizSessionRepository.save(session);

        AnswerResponseDTO response = new AnswerResponseDTO();
        response.setCorrect(correct);
        response.setCorrectAnswer(question.getCorrectAnswer());
        return response;
    }

    public QuizSummaryDTO getQuizSummary(Long sessionId) {
        QuizSession session = quizSessionRepository.findById(sessionId)
                .orElseThrow(() -> new RuntimeException("Session not found"));

        QuizSummaryDTO summary = new QuizSummaryDTO();
        summary.setTotalQuestions(session.getAnsweredQuestions().size());
        summary.setCorrectAnswers(session.getCorrectAnswers());
        summary.setCorrectAnswers(session.getCorrectAnswers());
        summary.setAnsweredQuestionIds(session.getAnsweredQuestions());
        return summary;
    }
}
