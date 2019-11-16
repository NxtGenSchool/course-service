package com.edu.school.courses.model.dto.group;

import com.edu.school.courses.model.group.Author;
import com.edu.school.courses.model.group.Group;

import java.time.LocalDate;

public class EventDto {

    private Long uidPk;
    private Group group;
    private Author author;
    private String title;
    private String Description;
    private String Location;
    private LocalDate Time;
    private LocalDate createdDate;

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
