package com.quiz.questionService.controller;

import com.quiz.questionService.entity.Question;
import com.quiz.questionService.service.QuestionService;
import com.quiz.questionService.util.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/question")
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;

    @PostMapping("/add")
    public ResponseEntity<Response> addQuiz(@RequestBody Question question) {
        Response response = questionService.addQuestion(question);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/fetch")
    public ResponseEntity<List<Question>> getAllQuizzes() {
        List<Question> questions = questionService.getAllQuestions();
        return ResponseEntity.ok(questions);
    }

    @GetMapping("/fetch/{id}")
    public ResponseEntity<Question> getQuiz(@PathVariable Long id) {
        Question question = questionService.getQuestion(id);
        return ResponseEntity.ok(question);
    }

    @GetMapping("/fetch/quiz/{id}")
    public ResponseEntity<List<Question>> getQuestionsByQuiz(@PathVariable Long id) {
        List<Question> questions = questionService.getQuestionsByQuiz(id);
        return ResponseEntity.ok(questions);
    }
}
