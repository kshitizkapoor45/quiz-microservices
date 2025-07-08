package com.quiz.questionService.service;

import com.quiz.questionService.entity.Question;
import com.quiz.questionService.repository.QuestionRepository;
import com.quiz.questionService.util.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class QuestionService {
    private final QuestionRepository questionRepository;

    public Response addQuestion(Question question) {
        log.info("Adding Question with name: {}", question.getTitle());
        questionRepository.save(question);
        return new Response("Question added successfully: " + question.getTitle());
    }

    public Question getQuestion(Long id) {
        log.info("Fetching Question with id: {}", id);
        return questionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Question not found with id: " + id));
    }

    public List<Question> getAllQuestions() {
        log.info("Fetching all Questions");
        return questionRepository.findAll();
    }

    public List<Question> getQuestionsByQuiz(Long id) {
        log.info("Fetching questions of quiz with id: {}", id);
        return questionRepository.findByQuizId(id);
    }
}
