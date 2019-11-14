package com.edu.school.courses.service.group;

import com.edu.school.courses.Repository.group.PostRepository;
import com.edu.school.courses.model.group.Comment;
import com.edu.school.courses.model.group.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    private PostRepository postRepository;

    @Autowired
    public CommentService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public void createComment(Long postId, Comment userComment) {
        Post post = postRepository.getOne(postId);
        List<Comment> comments = post.getComments();
        comments.add(userComment);
        postRepository.save(post);
    }

    public List<Comment> getAllComments(Long postId) {
        Post post = postRepository.getOne(postId);
        return post.getComments();
    }
}
