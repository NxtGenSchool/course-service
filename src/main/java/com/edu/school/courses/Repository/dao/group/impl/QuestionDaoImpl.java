package com.edu.school.courses.Repository.dao.group.impl;

import com.edu.school.courses.Repository.dao.group.QuestionDao;
import com.edu.school.courses.Repository.group.QuestionRepository;
import com.edu.school.courses.model.group.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QuestionDaoImpl implements QuestionDao {

    private QuestionRepository questionRepository;

    @Autowired
    public QuestionDaoImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public Question createQuestion(Question question) {
        Question newQuestion = questionRepository.save(question);
        return newQuestion;
    }

    @Override
    public Question getQuestion(Long questionId) {
        Question question = questionRepository.getOne(questionId);
        return question;
    }

    @Override
    public List<Question> getAllQuestion() {
        List<Question> questions = questionRepository.findAll();
        return questions;
    }

    @Override
    public Question updateQuestion(Question question) {
        Question updatedQuestion = questionRepository.save(question);
        return updatedQuestion;
    }
}
