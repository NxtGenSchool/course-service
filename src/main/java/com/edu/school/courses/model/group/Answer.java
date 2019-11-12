package com.edu.school.courses.model.group;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.OneToOne;
import java.time.LocalDate;

@Embeddable
public class Answer {

    @OneToOne(cascade = CascadeType.ALL)
    private Author author;
    private String content;
    private LocalDate createdDate;
    private int likes;

    public Author getAuthor() {
        return author;
    }

    public void setAuthorUID(Author authorUID) {
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

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}
