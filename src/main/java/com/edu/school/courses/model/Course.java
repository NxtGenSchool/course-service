package com.edu.school.courses.model;

import com.edu.school.courses.model.group.Group;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long uidPk;

    @OneToOne(cascade = CascadeType.ALL)
    private Group group;

    private LocalDate startDate;
    private LocalDate endDate;

    @ElementCollection(fetch = FetchType.EAGER)
    @JoinTable(name = "COURSE_SCHEDULE",
            joinColumns = @JoinColumn(name = "COURSE_ID"))
    private List<CourseSchedule> courseSchedules;

    public static Course getInstance() {
        Course newCourse = new Course();
        newCourse.setGroup(new Group());
        return newCourse;
    }

    public static Course getInstance(Course givenCourse) {
        Course newCourse = new Course();
        newCourse.setGroup(new Group());
        newCourse.setStartDate(givenCourse.getStartDate());
        newCourse.setEndDate(givenCourse.endDate);
        newCourse.setCourseSchedules(givenCourse.getCourseSchedules());
        return newCourse;
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

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public List<CourseSchedule> getCourseSchedules() {
        return courseSchedules;
    }

    public void setCourseSchedules(List<CourseSchedule> courseSchedules) {
        this.courseSchedules = courseSchedules;
    }
}
