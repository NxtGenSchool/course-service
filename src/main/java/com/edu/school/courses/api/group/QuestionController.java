package com.edu.school.courses.api.group;

import com.edu.school.courses.model.dto.group.AnswerDto;
import com.edu.school.courses.model.dto.group.QuestionDto;
import com.edu.school.courses.service.group.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("courses/{courseId}/group/")
public class QuestionController {

    private QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping(path = "questions", produces = APPLICATION_JSON_VALUE)
    public QuestionDto createQuestion(@PathVariable Long courseId, @RequestBody QuestionDto userQuestion) {
        return questionService.createQuestion(courseId, userQuestion);
    }

    @GetMapping(path = "questions/{questionId}", produces = APPLICATION_JSON_VALUE)
    public QuestionDto getQuestion(@PathVariable Long questionId) {
        return questionService.getQuestion(questionId);
    }

    @GetMapping(path = "questions/all", produces = APPLICATION_JSON_VALUE)
    public List<QuestionDto> getAllQuestion() {
        return questionService.getAllQuestion();
    }

    @PutMapping(path = "questions/{questionId}/ask", produces = APPLICATION_JSON_VALUE)
    public void incrementLike(@PathVariable Long questionId) {
        questionService.incrementAsk(questionId);
    }

    @PostMapping(path = "questions/{questionId}/answers", produces = APPLICATION_JSON_VALUE)
    public QuestionDto createAnswer(@PathVariable Long questionId, @RequestBody AnswerDto userAnswer) {
        return questionService.createAnswer(questionId, userAnswer);
    }

    //TODO: Get answer by id api missing

    @GetMapping(path = "questions/{questionId}/answers/all", produces = APPLICATION_JSON_VALUE)
    public List<AnswerDto> getAllAnswer(@PathVariable Long questionId) {
        return questionService.getAllAnswers(questionId);
    }

    @PutMapping(path = "questions/{questionId}/answers/{answerId}", produces = APPLICATION_JSON_VALUE)
    public void incrementAnswerLike(@PathVariable Long questionId, @PathVariable String answerId) {
        questionService.incrementAnswerLike(questionId, answerId);
    }

}
