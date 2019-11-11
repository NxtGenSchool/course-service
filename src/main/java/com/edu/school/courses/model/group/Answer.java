package com.edu.school.courses.model.group;

import javax.persistence.Embeddable;
import java.time.LocalDate;

@Embeddable
public class Answer {
    private Long authorUID;
    private String content;
    private LocalDate createdDate;
    private int likes;

    public Long getAuthorUID() {
        return authorUID;
    }

    public void setAuthorUID(Long authorUID) {
        this.authorUID = authorUID;
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
