package com.edu.school.courses.api.group;

import com.edu.school.courses.model.group.Question;
import com.edu.school.courses.service.group.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class QuestionController {

    private QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping(path = "questions/create", produces = APPLICATION_JSON_VALUE)
    public Question createQuestion() {
        return questionService.createQuestion();
    }

    @GetMapping(path = "questions/{questionId}", produces = APPLICATION_JSON_VALUE)
    public Question getQuestion(@PathVariable Long questionId) {
        return questionService.getQuestion(questionId);
    }

    @GetMapping(path = "questions/all", produces = APPLICATION_JSON_VALUE)
    public List<Question> getAllQuestion() {
        return questionService.getAllQuestion();
    }

}
