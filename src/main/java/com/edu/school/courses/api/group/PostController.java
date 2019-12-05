package com.edu.school.courses.api.group;

import com.edu.school.courses.model.dto.group.PostDto;
import com.edu.school.courses.model.group.Post;
import com.edu.school.courses.service.group.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("courses/{courseId}/group/")
public class PostController {

    private PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping(path = "posts", produces = APPLICATION_JSON_VALUE)
    public PostDto createPost(@PathVariable Long courseId, @RequestBody PostDto userPostDto) {
        Post userPost = PostDto.PostDtoToPostMapper(userPostDto);
        Post newPost = postService.createPost(courseId, userPost);
        return PostDto.PostToPostDtoMapper(newPost);
    }

    @GetMapping(path = "posts/{postId}", produces = APPLICATION_JSON_VALUE)
    public PostDto getPost(@PathVariable Long postId) {
        Post post = postService.getPost(postId);
        return PostDto.PostToPostDtoMapper(post);
    }

    @GetMapping(path = "posts/all", produces = APPLICATION_JSON_VALUE)
    public List<PostDto> getAllPost() {
        List<Post> posts = postService.getAllPost();
        return PostDto.PostToPostDtoMapper(posts);
    }

    @PutMapping(path = "posts/{postId}/like", produces = APPLICATION_JSON_VALUE)
    public void incrementLike(@PathVariable Long postId) {
        postService.incrementLike(postId);
    }
}
