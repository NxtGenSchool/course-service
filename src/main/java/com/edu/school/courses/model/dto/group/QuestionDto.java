package com.edu.school.courses.model.dto.group;

import com.edu.school.courses.model.group.Answer;
import com.edu.school.courses.model.group.Author;
import com.edu.school.courses.model.group.Comment;
import com.edu.school.courses.model.group.Group;

import java.time.LocalDate;
import java.util.List;

public class QuestionDto {

    private Long uidPk;
    private Group group;
    private Author author;
    private String content;
    private LocalDate createdDate;
    private int ask;
    private List<Comment> comments;
    private List<Answer> answers;

    public Long getUidPk() {
        return uidPk;
    }

    public void setUidPk(Long uidPk) {
        this.uidPk = uidPk;
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

    public int getAsk() {
        return ask;
    }

    public void setAsk(int ask) {
        this.ask = ask;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}
