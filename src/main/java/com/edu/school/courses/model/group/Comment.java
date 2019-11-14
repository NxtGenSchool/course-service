package com.edu.school.courses.model.group;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.OneToOne;
import java.time.LocalDate;

@Embeddable
public class Comment {

    @OneToOne(cascade = CascadeType.ALL)
    private Author author;
    private String content;
    private LocalDate createdDate;

    public static Comment getInstance(Comment userComment) {
        Comment newComment = new Comment();
        newComment.setAuthor(userComment.getAuthor());
        newComment.setContent(userComment.getContent());
        newComment.setCreatedDate(userComment.getCreatedDate());
        return newComment;
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
