package com.edu.school.courses.api.group;

import com.edu.school.courses.model.group.Post;
import com.edu.school.courses.service.group.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class PostController {

    private PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping(path = "posts/create", produces = APPLICATION_JSON_VALUE)
    public Post createPost() {
        return postService.createPost();
    }

    @GetMapping(path = "posts/{postId}", produces = APPLICATION_JSON_VALUE)
    public Post getPost(@PathVariable Long postId) {
        return postService.getPost(postId);
    }

    @GetMapping(path = "posts/all", produces = APPLICATION_JSON_VALUE)
    public List<Post> getAllPost() {
        return postService.getAllPost();
    }
}
