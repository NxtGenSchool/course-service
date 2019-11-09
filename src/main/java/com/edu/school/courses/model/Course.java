package com.edu.school.courses.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Course {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Long uidPk;

    private LocalDate startDate;
    private LocalDate endDate;

//    @ElementCollection(fetch = FetchType.EAGER)
//    @JoinTable( name = "COURSE_SCHEDULE" ,
//                joinColumns = @JoinColumn(name = "COURSE_ID"))
//    private List<CourseSchedule> courseSchedules;

    public Long getUidPk() {
        return uidPk;
    }

    public void setUidPk(Long uidPk) {
        this.uidPk = uidPk;
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

//    public List<CourseSchedule> getCourseSchedules() {
//        return courseSchedules;
//    }
//
//    public void setCourseSchedules(List<CourseSchedule> courseSchedules) {
//        this.courseSchedules = courseSchedules;
//    }
}
