package com.edu.school.courses.api.group;

import com.edu.school.courses.model.dto.group.CommentDto;
import com.edu.school.courses.model.group.Comment;
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
        Comment userComment = CommentDto.CommentDtoToCommentMapper(userCommentDto);
        commentService.createCommentForPost(postId, userComment);
    }

    @GetMapping(path = "posts/{postId}/comments/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CommentDto> getAllCommentsForPost(@PathVariable Long postId) {
        List<Comment> comments = commentService.getAllCommentsForPost(postId);
        return CommentDto.CommentToCommentDtoMapper(comments);
    }

    @PostMapping(path = "questions/{questionId}/comments", produces = MediaType.APPLICATION_JSON_VALUE)
    public void createCommentForQuestion(@PathVariable Long questionId, @RequestBody CommentDto userCommentDto) {
        Comment userComment = CommentDto.CommentDtoToCommentMapper(userCommentDto);
        commentService.createCommentForQuestion(questionId, userComment);
    }

    @GetMapping(path = "questions/{questionId}/comments/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CommentDto> getAllCommentsForQuestion(@PathVariable Long questionId) {
        List<Comment> comments = commentService.getAllCommentsOfQuestion(questionId);
        return CommentDto.CommentToCommentDtoMapper(comments);
    }
}
