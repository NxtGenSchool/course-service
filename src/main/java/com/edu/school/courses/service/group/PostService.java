package com.edu.school.courses.service.group;

import com.edu.school.courses.Repository.dao.group.PostDao;
import com.edu.school.courses.model.dto.group.CommentDto;
import com.edu.school.courses.model.dto.group.PostDto;
import com.edu.school.courses.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private PostDao postDao;
    private CourseService courseService;

    @Autowired
    public PostService(PostDao postDao, CourseService courseService) {
        this.postDao = postDao;
        this.courseService = courseService;
    }

    public PostDto createPost(Long courseId, PostDto postDto) {
        postDto.setGroup(courseService.getCourse(courseId).getGroup());
        return postDao.createPost(postDto);
    }

    public PostDto getPost(Long postId) {
        return postDao.getPost(postId);
    }

    public List<PostDto> getAllPost() {
        return postDao.getAllPost();
    }

    public void incrementLike(Long postId) {
        PostDto post = postDao.getPost(postId);
        int likes = post.getLikes();
        post.setLikes(++likes);
        postDao.updatePost(post);
    }

    public void createCommentForPost(Long postId, CommentDto userCommentDto) {
        PostDto postDto = postDao.getPost(postId);
        postDto.getComments().add(CommentDto.CommentDtoToCommentMapper(userCommentDto));
        postDao.updatePost(postDto);
    }

    public List<CommentDto> getAllCommentsOfPostById(Long postId) {
        return CommentDto.CommentToCommentDtoMapper(postDao.getPost(postId).getComments());
    }
}
