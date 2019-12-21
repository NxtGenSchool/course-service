package com.edu.school.courses.service.group;

import com.edu.school.courses.Repository.dao.group.QuestionDao;
import com.edu.school.courses.model.group.Answer;
import com.edu.school.courses.model.group.Comment;
import com.edu.school.courses.model.group.Question;
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

    public Question createQuestion(Long courseId, Question userQuestion) {
        userQuestion.setGroup(courseService.getCourse(courseId).getGroup());
        Question newQuestion = questionDao.createQuestion(userQuestion);
        return newQuestion;
    }

    public Question getQuestion(Long questionId) {
        Question question = questionDao.getQuestion(questionId);
        return question;
    }

    public List<Question> getAllQuestion() {
        List<Question> questions = questionDao.getAllQuestion();
        return questions;
    }

    public void createCommentForQuestion(Long questionId, Comment userComment) {
        Question question = questionDao.getQuestion(questionId);
        question.getComments().add(userComment);
        questionDao.updateQuestion(question);
    }

    public List<Comment> getAllCommentsOfQuestionById(Long questionId) {
        Question question = questionDao.getQuestion(questionId);
        return question.getComments();
    }

    public void incrementAsk(Long questionId) {
        Question question = questionDao.getQuestion(questionId);
        int asks = question.getAsk();
        question.setAsk(++asks);
        questionDao.updateQuestion(question);
    }

    public Question createAnswer(Long questionId, Answer userAnswer) {
        Question question = questionDao.getQuestion(questionId);
        question.getAnswers().add(userAnswer);
        return questionDao.updateQuestion(question);
    }

    public void incrementAnswerLike(Long questionId, String answerId) {
        Question question = questionDao.getQuestion(questionId);
        question.getAnswers().forEach(answer -> {
            if (answer.getUidPk().equals(answerId)) {
                int likes = answer.getLikes();
                answer.setLikes(++likes);
            }
        });
        questionDao.updateQuestion(question);
    }

    public List<Answer> getAllAnswers(Long questionId) {
        Question question = questionDao.getQuestion(questionId);
        return question.getAnswers();
    }
}
