package com.edu.school.courses.Repository.dao.group;

import com.edu.school.courses.model.group.Question;

import java.util.List;

public interface QuestionDao {
    Question createQuestion(Question userQuestion);

    Question getQuestion(Long questionId);

    List<Question> getAllQuestion();

    Question updateQuestion(Question question);
}
