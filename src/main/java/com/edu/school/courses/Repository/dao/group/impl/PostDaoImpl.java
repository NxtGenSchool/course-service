package com.edu.school.courses.Repository.dao.group.impl;

import com.edu.school.courses.Repository.dao.group.PostDao;
import com.edu.school.courses.Repository.group.PostRepository;
import com.edu.school.courses.model.group.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PostDaoImpl implements PostDao {

    private PostRepository postRepository;

    @Autowired
    public PostDaoImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Post createPost(Post post) {
        Post newPost = postRepository.save(post);
        return newPost;
    }

    @Override
    public Post getPost(Long postId) {
        Post post = postRepository.getOne(postId);
        return post;
    }

    @Override
    public Post updatePost(Post post) {
        Post updated = postRepository.save(post);
        return updated;
    }

    @Override
    public List<Post> getAllPost() {
        List<Post> posts = postRepository.findAll();
        return posts;
    }
}
