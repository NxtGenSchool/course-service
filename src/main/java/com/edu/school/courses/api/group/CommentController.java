package com.edu.school.courses.api.group;

import com.edu.school.courses.model.dto.group.CommentDto;
import com.edu.school.courses.service.group.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("courses/{courseId}/group/")
public class CommentController {

    private CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping(path = "posts/{postId}/comments", produces = MediaType.APPLICATION_JSON_VALUE)
    public void createCommentForPost(@PathVariable Long postId, @RequestBody CommentDto userCommentDto) {
        commentService.createCommentForPost(postId, userCommentDto);
    }

    @GetMapping(path = "posts/{postId}/comments/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CommentDto> getAllCommentsForPost(@PathVariable Long postId) {
        return commentService.getAllCommentsForPost(postId);
    }

    @PostMapping(path = "questions/{questionId}/comments", produces = MediaType.APPLICATION_JSON_VALUE)
    public void createCommentForQuestion(@PathVariable Long questionId, @RequestBody CommentDto userCommentDto) {
        commentService.createCommentForQuestion(questionId, userCommentDto);
    }

    @GetMapping(path = "questions/{questionId}/comments/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CommentDto> getAllCommentsForQuestion(@PathVariable Long questionId) {
        return commentService.getAllCommentsOfQuestion(questionId);
    }
}
