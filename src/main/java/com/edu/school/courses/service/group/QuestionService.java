package com.edu.school.courses.service.group;

import com.edu.school.courses.Repository.group.QuestionRepository;
import com.edu.school.courses.model.group.Comment;
import com.edu.school.courses.model.group.Question;
import com.edu.school.courses.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    private QuestionRepository questionRepository;
    private CourseService courseService;

    @Autowired
    public QuestionService(QuestionRepository questionRepository, CourseService courseService) {
        this.questionRepository = questionRepository;
        this.courseService = courseService;
    }

    public Question createQuestion(Long courseId, Question userQuestion) {
        Question newQuestion = Question.getInstance(userQuestion);
        newQuestion.setGroup(courseService.getCourse(courseId).getGroup());
        return questionRepository.save(newQuestion);
    }

    public Question getQuestion(Long questionId) {
        return questionRepository.getOne(questionId);
    }

    public List<Question> getAllQuestion() {
        return questionRepository.findAll();
    }

    public void createComment(Long questionId, Comment userComment) {
        Question question = questionRepository.getOne(questionId);
        Comment newComment = Comment.getInstance(userComment);
    }

    public List<Comment> getAllComments(Long questionId) {
        Question question = questionRepository.getOne(questionId);
        return question.getComments();
    }

    public void increamentAsk(Long questionId) {
        Question question = questionRepository.getOne(questionId);
        int asks = question.getAsk();
        question.setAsk(++asks);
        questionRepository.save(question);
    }
}
