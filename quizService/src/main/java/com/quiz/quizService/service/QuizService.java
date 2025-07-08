package com.quiz.quizService.service;

import com.quiz.quizService.entity.Quiz;
import com.quiz.quizService.repository.QuizRepository;
import com.quiz.quizService.util.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class QuizService {
    private final QuizRepository quizRepository;

    public Response addQuiz(Quiz quiz) {
        log.info("Adding quiz with name: {}", quiz.getTitle());
        quizRepository.save(quiz);
        return new Response("Quiz added successfully: " + quiz.getTitle());
    }

    public Quiz getQuiz(Long id) {
        log.info("Fetching quiz with id: {}", id);
        return quizRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Quiz not found with id: " + id));
    }

    public List<Quiz> getAllQuiz() {
        log.info("Fetching all quizes");
        return quizRepository.findAll();
    }
}
