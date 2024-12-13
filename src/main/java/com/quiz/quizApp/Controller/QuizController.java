package com.quiz.quizApp.Controller;

import com.quiz.quizApp.DTO.*;
import com.quiz.quizApp.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.quiz.quizApp.Entity.QuizSession;
import com.quiz.quizApp.Repository.QuestionRepository;
import com.quiz.quizApp.Entity.Question;

@RestController
@RequestMapping("/")
public class QuizController {

    @Autowired
    private QuizService quizService;
    @Autowired
    private QuestionRepository questionRepository;

    @PostMapping("/postquestion")
    public ResponseEntity<String> addQuestion(@RequestBody Question question) {
        try {
            questionRepository.save(question);
            return ResponseEntity.ok("Question added successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error adding question: " + e.getMessage());
        
        }
    }
    @PostMapping("/start")
    public QuizSession startQuiz(@RequestParam String userId) {
        return quizService.startQuiz(userId);
    }

    @GetMapping("/question")
    public QuestionDTO getRandomQuestion(@RequestParam Long sessionId) {
        return quizService.getRandomQuestion(sessionId);
    }

    @PostMapping("/answer")
    public AnswerResponseDTO submitAnswer(@RequestParam Long sessionId, @RequestParam Long questionId, @RequestParam String answer) {
        return quizService.submitAnswer(sessionId, questionId, answer);
    }

    @GetMapping("/summary")
    public QuizSummaryDTO getQuizSummary(@RequestParam Long sessionId) {
        return quizService.getQuizSummary(sessionId);
    }
}
