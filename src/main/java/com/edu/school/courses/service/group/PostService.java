package com.edu.school.courses.service.group;

import com.edu.school.courses.Repository.group.PostRepository;
import com.edu.school.courses.model.group.Post;
import com.edu.school.courses.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private PostRepository postRepository;
    private CourseService courseService;

    @Autowired
    public PostService(PostRepository postRepository, CourseService courseService) {
        this.postRepository = postRepository;
        this.courseService = courseService;
    }

    public Post createPost(Long courseId, Post userPost) {
        Post newPost = Post.getInstance(userPost);
        newPost.setGroup(courseService.getCourse(courseId).getGroup());
        return postRepository.save(newPost);
    }

    public Post getPost(Long postId) {
        return postRepository.getOne(postId);
    }

    public List<Post> getAllPost() {
        return postRepository.findAll();
    }

    public void increamentLike(Long postId) {
        Post post = postRepository.getOne(postId);
        int likes = post.getLikes();
        post.setLikes(++likes);
        postRepository.save(post);
    }
}
