package com.edu.school.courses.model.group;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long uidPk;

    //TODO: change Group to group
    @ManyToOne(targetEntity = Group.class)
    @JsonIgnore
    private Group group;

    @OneToOne(cascade = CascadeType.ALL)
    private Author author;
    private String title;
    private String Description;
    private String Location;
    private LocalDate Time;
    private LocalDate createdDate;

    public static Event getDuplicateInstance(Event event) {
        Event newEvent = new Event();
        newEvent.setAuthor(event.getAuthor());
        newEvent.setCreatedDate(event.getCreatedDate());
        newEvent.setDescription(event.getDescription());
        newEvent.setLocation(event.getLocation());
        newEvent.setTitle(event.getTitle());
        newEvent.setTime(event.getTime());
        newEvent.setGroup(event.getGroup());
        return newEvent;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public LocalDate getTime() {
        return Time;
    }

    public void setTime(LocalDate time) {
        Time = time;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }
}
