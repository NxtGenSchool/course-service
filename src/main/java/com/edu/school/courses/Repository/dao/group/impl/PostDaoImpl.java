package com.edu.school.courses.Repository.dao.group.impl;

import com.edu.school.courses.Repository.dao.group.PostDao;
import com.edu.school.courses.Repository.group.PostRepository;
import com.edu.school.courses.model.dto.group.PostDto;
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
    public PostDto createPost(PostDto postDto) {
        return PostDto.PostToPostDtoMapper(postRepository.save(PostDto.PostDtoToPostMapper(postDto)));
    }

    @Override
    public PostDto getPost(Long postId) {
        return PostDto.PostToPostDtoMapper(postRepository.getOne(postId));
    }

    @Override
    public PostDto updatePost(PostDto postDto) {
        return PostDto.PostToPostDtoMapper(postRepository.save(PostDto.PostDtoToPostMapper(postDto)));
    }

    @Override
    public List<PostDto> getAllPost() {
        return PostDto.PostToPostDtoMapper(postRepository.findAll());
    }
}
