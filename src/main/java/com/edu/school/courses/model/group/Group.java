package com.edu.school.courses.model.group;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@javax.persistence.Table(name = "\"group\"")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long uidPk;
    private String admin;

    @ElementCollection
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<String> moderator;

    @OneToMany(mappedBy = "groupId")
    private List<Member> members;

    @OneToMany(mappedBy = "groupId")
    private List<Post> posts;

    @OneToMany(mappedBy = "groupId")
    private List<Question> questions;

    @OneToMany(mappedBy = "groupId")
    private List<Poll> polls;

    @OneToMany(mappedBy = "groupId")
    private List<Event> events;

//    @JsonCreator
//    public static Group getInstance() {
//        return new Group();
//    }

//    private Group(){}

    public Long getUidPk() {
        return uidPk;
    }

    public void setUidPk(Long uidPk) {
        this.uidPk = uidPk;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public List<String> getModerator() {
        return moderator;
    }

    public void setModerator(List<String> moderator) {
        this.moderator = moderator;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public List<Poll> getPolls() {
        return polls;
    }

    public void setPolls(List<Poll> polls) {
        this.polls = polls;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

}
