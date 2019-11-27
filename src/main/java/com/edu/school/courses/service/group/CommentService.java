package com.edu.school.courses.service.group;

import com.edu.school.courses.model.dto.group.CommentDto;
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

    public void createCommentForPost(Long postId, CommentDto userCommentDto) {
        postService.createCommentForPost(postId, userCommentDto);
    }

    public List<CommentDto> getAllCommentsForPost(Long postId) {
        return postService.getAllCommentsOfPostById(postId);
    }


    public void createCommentForQuestion(Long questionId, CommentDto userCommentDto) {
        questionService.createCommentForQuestion(questionId, userCommentDto);
    }

    public List<CommentDto> getAllCommentsOfQuestion(Long questionId) {
        return questionService.getAllCommentsOfQuestionById(questionId);
    }
}
