package com.edu.school.courses.service.group;

import com.edu.school.courses.Repository.group.QuestionRepository;
import com.edu.school.courses.model.group.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    private QuestionRepository questionRepository;

    @Autowired
    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public Question createQuestion() {
        return questionRepository.save(new Question());
    }

    public Question getQuestion(Long questionId) {
        return questionRepository.getOne(questionId);
    }

    public List<Question> getAllQuestion() {
        return questionRepository.findAll();
    }
}
