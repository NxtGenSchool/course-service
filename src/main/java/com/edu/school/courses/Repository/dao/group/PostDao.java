package com.edu.school.courses.Repository.dao.group;

import com.edu.school.courses.model.dto.group.PostDto;

import java.util.List;

public interface PostDao {

    PostDto createPost(PostDto postDto);

    PostDto getPost(Long postId);

    PostDto updatePost(PostDto postDto);

    List<PostDto> getAllPost();
}
