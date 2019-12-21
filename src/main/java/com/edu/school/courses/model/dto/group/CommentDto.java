package com.edu.school.courses.model.dto.group;

import com.edu.school.courses.model.group.Author;
import com.edu.school.courses.model.group.Comment;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CommentDto {

    private Author author;
    private String content;
    private LocalDate createdDate;

    public static Comment CommentDtoToCommentMapper(CommentDto commentDto) {
        Comment comment = new Comment();
        if (commentDto != null) {
            comment.setContent(commentDto.getContent());
            comment.setAuthor(commentDto.getAuthor());
            comment.setCreatedDate(commentDto.getCreatedDate());
        }
        return comment;
    }

    public static CommentDto CommentToCommentDtoMapper(Comment comment) {
        CommentDto commentDto = new CommentDto();
        if (comment != null) {
            commentDto.setContent(comment.getContent());
            commentDto.setAuthor(comment.getAuthor());
            commentDto.setCreatedDate(comment.getCreatedDate());
        }
        return commentDto;
    }

    public static List<CommentDto> CommentToCommentDtoMapper(List<Comment> commentsList) {
        List<CommentDto> commentDtoList = new ArrayList<>();
        for (Comment comment : commentsList) {
            CommentDto commentDto = new CommentDto();
            commentDto.setContent(comment.getContent());
            commentDto.setAuthor(comment.getAuthor());
            commentDto.setCreatedDate(comment.getCreatedDate());
            commentDtoList.add(commentDto);
        }
        return commentDtoList;
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
}
