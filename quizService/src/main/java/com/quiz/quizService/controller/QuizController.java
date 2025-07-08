package com.quiz.quizService.controller;

import com.quiz.quizService.entity.Quiz;
import com.quiz.quizService.service.QuizService;
import com.quiz.quizService.util.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quiz")
@RequiredArgsConstructor
public class QuizController {

    private final QuizService quizService;

    @PostMapping("/add")
    public ResponseEntity<Response> addQuiz(@RequestBody Quiz question) {
        Response response = quizService.addQuiz(question);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/fetch")
    public ResponseEntity<List<Quiz>> getAllQuizzes() {
        List<Quiz> questions = quizService.getAllQuiz();
        return ResponseEntity.ok(questions);
    }

    @GetMapping("/fetch/{id}")
    public ResponseEntity<Quiz> getQuiz(@PathVariable Long id) {
        Quiz question = quizService.getQuiz(id);
        return ResponseEntity.ok(question);
    }
}
