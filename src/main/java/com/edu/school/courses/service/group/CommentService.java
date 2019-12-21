package com.edu.school.courses.service.group;

import com.edu.school.courses.model.group.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    private PostService postService;
    private QuestionService questionService;

    @Autowired
    public CommentService(PostService postService, QuestionService questionService) {
        this.postService = postService;
        this.questionService = questionService;
    }

    public void createCommentForPost(Long postId, Comment userComment) {
        postService.createCommentForPost(postId, userComment);
    }

    public List<Comment> getAllCommentsForPost(Long postId) {
        return postService.getAllCommentsOfPostById(postId);
    }


    public void createCommentForQuestion(Long questionId, Comment userComment) {
        questionService.createCommentForQuestion(questionId, userComment);
    }

    public List<Comment> getAllCommentsOfQuestion(Long questionId) {
        return questionService.getAllCommentsOfQuestionById(questionId);
    }
}
