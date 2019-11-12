package com.edu.school.courses.model.group;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long uidPk;

    //TODO: change Group to groupId
    @ManyToOne(targetEntity = Group.class)
    @JsonIgnore
    private Group group;

    @OneToOne(cascade = CascadeType.ALL)
    private Author author;
    private String content;
    private LocalDate createdDate;
    private int ask;

    @ElementCollection
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Comment> comments;

    @ElementCollection
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Answer> answers;

    public static Question getInstance(Question userQuestion) {
        Question newQuestion = new Question();
        newQuestion.setContent(userQuestion.getContent());
        newQuestion.setAuthor(userQuestion.getAuthor());
        newQuestion.setAnswers(userQuestion.getAnswers());
        newQuestion.setComments(userQuestion.getComments());
        newQuestion.setCreatedDate(userQuestion.getCreatedDate());
        newQuestion.setAsk(userQuestion.getAsk());
        return newQuestion;
    }

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
