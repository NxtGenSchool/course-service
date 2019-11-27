package com.edu.school.courses.Repository.dao.group.impl;

import com.edu.school.courses.Repository.dao.group.QuestionDao;
import com.edu.school.courses.Repository.group.QuestionRepository;
import com.edu.school.courses.model.dto.group.QuestionDto;
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
    public QuestionDto createQuestion(QuestionDto questionDto) {
        return QuestionDto.QuestionToQuestionDtoMapper(questionRepository.save(QuestionDto.QuestionDtoToQuestionMapper(questionDto)));
    }

    @Override
    public QuestionDto getQuestion(Long questionId) {
        return QuestionDto.QuestionToQuestionDtoMapper(questionRepository.getOne(questionId));
    }

    @Override
    public List<QuestionDto> getAllQuestion() {
        return QuestionDto.QuestionToQuestionDtoMapper(questionRepository.findAll());
    }

    @Override
    public QuestionDto updateQuestion(QuestionDto questionDto) {
        return QuestionDto.QuestionToQuestionDtoMapper(questionRepository.save(QuestionDto.QuestionDtoToQuestionMapper(questionDto)));
    }
}
