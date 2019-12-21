package com.edu.school.courses.Repository.dao.group;

import com.edu.school.courses.model.group.Post;

import java.util.List;

public interface PostDao {

    Post createPost(Post post);

    Post getPost(Long postId);

    Post updatePost(Post post);

    List<Post> getAllPost();
}
