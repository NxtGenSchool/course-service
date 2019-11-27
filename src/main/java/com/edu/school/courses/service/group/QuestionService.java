package com.edu.school.courses.service.group;

import com.edu.school.courses.Repository.dao.group.QuestionDao;
import com.edu.school.courses.model.dto.group.AnswerDto;
import com.edu.school.courses.model.dto.group.CommentDto;
import com.edu.school.courses.model.dto.group.QuestionDto;
import com.edu.school.courses.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    private QuestionDao questionDao;
    private CourseService courseService;

    @Autowired
    public QuestionService(QuestionDao questionDao, CourseService courseService) {
        this.questionDao = questionDao;
        this.courseService = courseService;
    }

    public QuestionDto createQuestion(Long courseId, QuestionDto userQuestionDto) {
        userQuestionDto.setGroup(courseService.getCourse(courseId).getGroup());
        return questionDao.createQuestion(userQuestionDto);
    }

    public QuestionDto getQuestion(Long questionId) {
        return questionDao.getQuestion(questionId);
    }

    public List<QuestionDto> getAllQuestion() {
        return questionDao.getAllQuestion();
    }

    public void createCommentForQuestion(Long questionId, CommentDto userCommentDto) {
        QuestionDto questionDto = questionDao.getQuestion(questionId);
        questionDto.getComments().add(CommentDto.CommentDtoToCommentMapper(userCommentDto));
        questionDao.updateQuestion(questionDto);
    }

    public List<CommentDto> getAllCommentsOfQuestionById(Long questionId) {
        QuestionDto question = questionDao.getQuestion(questionId);
        return CommentDto.CommentToCommentDtoMapper(question.getComments());
    }

    public void incrementAsk(Long questionId) {
        QuestionDto questionDto = questionDao.getQuestion(questionId);
        int asks = questionDto.getAsk();
        questionDto.setAsk(++asks);
        questionDao.updateQuestion(questionDto);
    }

    public QuestionDto createAnswer(Long questionId, AnswerDto userAnswerDto) {
        QuestionDto questionDto = questionDao.getQuestion(questionId);
        questionDto.getAnswers().add(AnswerDto.AnswerDtoToAnswerMapper(userAnswerDto));
        return questionDao.updateQuestion(questionDto);
    }

    public void incrementAnswerLike(Long questionId, String answerId) {
        QuestionDto questionDto = questionDao.getQuestion(questionId);
        questionDto.getAnswers().forEach(answer -> {
            if (answer.getUidPk().equals(answerId)) {
                int likes = answer.getLikes();
                answer.setLikes(++likes);
            }
        });
        questionDao.updateQuestion(questionDto);
    }

    public List<AnswerDto> getAllAnswers(Long questionId) {
        QuestionDto questionDto = questionDao.getQuestion(questionId);
        return AnswerDto.AnswerToAnswerDtoMapper(questionDto.getAnswers());
    }
}
