package com.edu.school.courses.model.dto.group;

import com.edu.school.courses.model.group.Author;
import com.edu.school.courses.model.group.Comment;
import com.edu.school.courses.model.group.Group;
import com.edu.school.courses.model.group.Post;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PostDto {

    private Long uidPk;
    private Group group;
    private Author author;
    private String content;
    private LocalDate createdDate;
    private int likes;
    private List<Comment> comments;

    public static Post PostDtoToPostMapper(PostDto postDto) {
        Post post = new Post();
        if (postDto != null) {
            post.setUidPk(postDto.getUidPk());
            post.setGroup(postDto.getGroup());
            post.setContent(postDto.getContent());
            post.setAuthor(postDto.getAuthor());
            post.setComments(postDto.getComments());
            post.setLikes(postDto.getLikes());
            post.setCreatedDate(postDto.getCreatedDate());
        }
        return post;
    }

    public static PostDto PostToPostDtoMapper(Post post) {
        PostDto postDto = new PostDto();
        if (post != null) {
            postDto.setUidPk(post.getUidPk());
            postDto.setContent(post.getContent());
            postDto.setGroup(post.getGroup());
            postDto.setAuthor(post.getAuthor());
            postDto.setComments(post.getComments());
            postDto.setLikes(post.getLikes());
            postDto.setCreatedDate(post.getCreatedDate());
        }
        return postDto;
    }

    public static List<PostDto> PostToPostDtoMapper(List<Post> postList) {
        List<PostDto> postDtoList = new ArrayList<>();
        for (Post post : postList) {
            PostDto postDto = new PostDto();
            postDto.setUidPk(post.getUidPk());
            postDto.setContent(post.getContent());
            postDto.setGroup(post.getGroup());
            postDto.setAuthor(post.getAuthor());
            postDto.setComments(post.getComments());
            postDto.setLikes(post.getLikes());
            postDto.setCreatedDate(post.getCreatedDate());
            postDtoList.add(postDto);
        }
        return postDtoList;
    }

    public Long getUidPk() {
        return uidPk;
    }

    public void setUidPk(Long uidPk) {
        this.uidPk = uidPk;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
