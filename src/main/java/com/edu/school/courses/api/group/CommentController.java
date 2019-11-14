package com.edu.school.courses.api.group;

import com.edu.school.courses.model.group.Comment;
import com.edu.school.courses.service.group.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("courses/{courseId}/group/posts/{postId}")
public class CommentController {

    private CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping(path = "/comments", produces = MediaType.APPLICATION_JSON_VALUE)
    public void createComment(@PathVariable Long postId, @RequestBody Comment userComment) {
        commentService.createComment(postId, userComment);
    }

    @GetMapping(path = "/comments/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Comment> getAllComments(@PathVariable Long postId) {
        return commentService.getAllComments(postId);
    }
}
