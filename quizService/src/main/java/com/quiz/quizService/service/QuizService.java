package com.quiz.quizService.service;

import com.quiz.quizService.entity.Quiz;
import com.quiz.quizService.repository.QuizRepository;
import com.quiz.quizService.util.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class QuizService {
    private final QuizRepository quizRepository;
    private final QuestionClient questionClient;

    public Response addQuiz(Quiz quiz) {
        log.info("Adding quiz with name: {}", quiz.getTitle());
        quizRepository.save(quiz);
        return new Response("Quiz added successfully: " + quiz.getTitle());
    }

    public Quiz getQuiz(Long id) {
        log.info("Fetching quiz with id: {}", id);
        Quiz quiz = quizRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Quiz not found with id: " + id));
        quiz.setQuestions(questionClient.getQuestionsByQuiz(quiz.getId()));
        return quiz;
    }

    public List<Quiz> getAllQuiz() {
        log.info("Fetching all quizes");
        List<Quiz> quizes = quizRepository.findAll();

        List<Quiz> quizWithQuestions = quizes.stream().map(quiz -> {
            quiz.setQuestions(questionClient.getQuestionsByQuiz(quiz.getId()));
            return quiz;
        }).collect(Collectors.toList());

        return quizWithQuestions;
    }
}
