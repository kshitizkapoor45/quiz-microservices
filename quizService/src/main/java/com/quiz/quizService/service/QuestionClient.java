package com.quiz.quizService.service;

import com.quiz.quizService.entity.Question;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(url = "http://localhost:8082", name = "question-service")
public interface QuestionClient {

    @GetMapping("/api/question/fetch/quiz/{quizId}")
    List<Question> getQuestionsByQuiz(@PathVariable Long quizId);
}
