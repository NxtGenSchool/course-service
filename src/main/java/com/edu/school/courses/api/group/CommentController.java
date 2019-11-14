package com.edu.school.courses.api.group;

import com.edu.school.courses.model.group.Comment;
import com.edu.school.courses.service.group.CommentService;
import com.edu.school.courses.service.group.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("courses/{courseId}/group/")
public class CommentController {

    private CommentService commentService;
    private QuestionService questionService;

    @Autowired
    public CommentController(CommentService commentService, QuestionService questionService) {
        this.commentService = commentService;
        this.questionService = questionService;
    }

    @PostMapping(path = "posts/{postId}/comments", produces = MediaType.APPLICATION_JSON_VALUE)
    public void createCommentForPost(@PathVariable Long postId, @RequestBody Comment userComment) {
        commentService.createComment(postId, userComment);
    }

    @GetMapping(path = "posts/{postId}/comments/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Comment> getAllCommentsForPost(@PathVariable Long postId) {
        return commentService.getAllComments(postId);
    }

    @PostMapping(path = "questions/{questionId}/comments", produces = MediaType.APPLICATION_JSON_VALUE)
    public void createCommentForQuestion(@PathVariable Long questionId, @RequestBody Comment userComment) {
        questionService.createComment(questionId, userComment);
    }

    @GetMapping(path = "questions/{questionId}/comments/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Comment> getAllCommentsForQuestion(@PathVariable Long questionId) {
        return questionService.getAllComments(questionId);
    }
}
