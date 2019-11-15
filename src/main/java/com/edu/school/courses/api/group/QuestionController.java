package com.edu.school.courses.api.group;

import com.edu.school.courses.model.group.Answer;
import com.edu.school.courses.model.group.Question;
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
    public Question createQuestion(@PathVariable Long courseId, @RequestBody Question userQuestion) {
        return questionService.createQuestion(courseId, userQuestion);
    }

    @GetMapping(path = "questions/{questionId}", produces = APPLICATION_JSON_VALUE)
    public Question getQuestion(@PathVariable Long questionId) {
        return questionService.getQuestion(questionId);
    }

    @GetMapping(path = "questions/all", produces = APPLICATION_JSON_VALUE)
    public List<Question> getAllQuestion() {
        return questionService.getAllQuestion();
    }

    @PutMapping(path = "questions/{questionId}/ask", produces = APPLICATION_JSON_VALUE)
    public void increamentLike(@PathVariable Long questionId) {
        questionService.increamentAsk(questionId);
    }

    @PostMapping(path = "questions/{questionId}/answers", produces = APPLICATION_JSON_VALUE)
    public Question createAnswer(@PathVariable Long questionId, @RequestBody Answer userAnswer) {
        return questionService.createAnswer(questionId, userAnswer);
    }
}
