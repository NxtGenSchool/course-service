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
public class Poll {

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
    private int likes;

    @ElementCollection
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Option> options;

    public static Poll getInstance(Poll userPoll) {
        Poll newPoll = new Poll();
        newPoll.setContent(userPoll.getContent());
        newPoll.setAuthor(userPoll.getAuthor());
        newPoll.setOptions(userPoll.getOptions());
        newPoll.setCreatedDate(userPoll.getCreatedDate());
        newPoll.setLikes(userPoll.getLikes());
        return newPoll;
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

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }
}
