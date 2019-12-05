package com.edu.school.courses.api.group;

import com.edu.school.courses.model.dto.group.AnswerDto;
import com.edu.school.courses.model.dto.group.QuestionDto;
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
    public QuestionDto createQuestion(@PathVariable Long courseId, @RequestBody QuestionDto userQuestionDto) {
        Question userQuestion = QuestionDto.QuestionDtoToQuestionMapper(userQuestionDto);
        Question newQuestion = questionService.createQuestion(courseId, userQuestion);
        return QuestionDto.QuestionToQuestionDtoMapper(newQuestion);
    }

    @GetMapping(path = "questions/{questionId}", produces = APPLICATION_JSON_VALUE)
    public QuestionDto getQuestion(@PathVariable Long questionId) {
        Question question = questionService.getQuestion(questionId);
        return QuestionDto.QuestionToQuestionDtoMapper(question);
    }

    @GetMapping(path = "questions/all", produces = APPLICATION_JSON_VALUE)
    public List<QuestionDto> getAllQuestion() {
        List<Question> questions = questionService.getAllQuestion();
        return QuestionDto.QuestionToQuestionDtoMapper(questions);
    }

    @PutMapping(path = "questions/{questionId}/ask", produces = APPLICATION_JSON_VALUE)
    public void incrementLike(@PathVariable Long questionId) {
        questionService.incrementAsk(questionId);
    }

    @PostMapping(path = "questions/{questionId}/answers", produces = APPLICATION_JSON_VALUE)
    public QuestionDto createAnswer(@PathVariable Long questionId, @RequestBody AnswerDto userAnswerDto) {
        Answer userAnswer = AnswerDto.AnswerDtoToAnswerMapper(userAnswerDto);
        Question question = questionService.createAnswer(questionId, userAnswer);
        return QuestionDto.QuestionToQuestionDtoMapper(question);
    }

    //TODO: Get answer by id api missing

    @GetMapping(path = "questions/{questionId}/answers/all", produces = APPLICATION_JSON_VALUE)
    public List<AnswerDto> getAllAnswer(@PathVariable Long questionId) {
        List<Answer> answers = questionService.getAllAnswers(questionId);
        return AnswerDto.AnswerToAnswerDtoMapper(answers);
    }

    @PutMapping(path = "questions/{questionId}/answers/{answerId}", produces = APPLICATION_JSON_VALUE)
    public void incrementAnswerLike(@PathVariable Long questionId, @PathVariable String answerId) {
        questionService.incrementAnswerLike(questionId, answerId);
    }

}
