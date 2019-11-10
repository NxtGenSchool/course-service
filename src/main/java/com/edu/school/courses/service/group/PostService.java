package com.edu.school.courses.service.group;

import com.edu.school.courses.Repository.group.PostRepository;
import com.edu.school.courses.model.group.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post createPost() {
        return postRepository.save(new Post());
    }

    public Post getPost(Long postId) {
        return postRepository.getOne(postId);
    }

    public List<Post> getAllPost() {
        return postRepository.findAll();
    }
}
