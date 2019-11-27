package com.edu.school.courses.Repository.dao.group;

import com.edu.school.courses.model.dto.group.QuestionDto;

import java.util.List;

public interface QuestionDao {
    QuestionDto createQuestion(QuestionDto userQuestion);

    QuestionDto getQuestion(Long questionId);

    List<QuestionDto> getAllQuestion();

    QuestionDto updateQuestion(QuestionDto questionDto);
}
