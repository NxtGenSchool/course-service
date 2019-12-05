package com.edu.school.courses.service.group;

import com.edu.school.courses.Repository.dao.group.PostDao;
import com.edu.school.courses.model.dto.group.CommentDto;
import com.edu.school.courses.model.group.Post;
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

    public Post createPost(Long courseId, Post post) {
        post.setGroup(courseService.getCourse(courseId).getGroup());
        Post newPost = postDao.createPost(post);
        return newPost;
    }

    public Post getPost(Long postId) {
        Post post = postDao.getPost(postId);
        return post;
    }

    public List<Post> getAllPost() {
        List<Post> posts = postDao.getAllPost();
        return posts;
    }

    public void incrementLike(Long postId) {
        Post post = postDao.getPost(postId);
        int likes = post.getLikes();
        post.setLikes(++likes);
        postDao.updatePost(post);
    }

    public void createCommentForPost(Long postId, CommentDto userCommentDto) {
        Post post = postDao.getPost(postId);
        post.getComments().add(CommentDto.CommentDtoToCommentMapper(userCommentDto));
        postDao.updatePost(post);
    }

    public List<CommentDto> getAllCommentsOfPostById(Long postId) {
        return CommentDto.CommentToCommentDtoMapper(postDao.getPost(postId).getComments());
    }
}
