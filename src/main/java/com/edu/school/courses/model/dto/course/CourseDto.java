package com.edu.school.courses.model.dto.course;

import com.edu.school.courses.model.Course;
import com.edu.school.courses.model.CourseSchedule;
import com.edu.school.courses.model.group.Group;

import java.time.LocalDate;
import java.util.List;

public class CourseDto {

    private Long uidPk;

    private Group group;

    private LocalDate startDate;
    private LocalDate endDate;
    private List<CourseSchedule> courseSchedules;


    public static CourseDto CourseToCourseDtoMapper(Course course) {
        CourseDto courseDto = new CourseDto();
        courseDto.setUidPk(course.getUidPk());
        courseDto.setGroup(course.getGroup());
        courseDto.setCourseSchedules(course.getCourseSchedules());
        courseDto.setStartDate(course.getStartDate());
        courseDto.setEndDate(course.getEndDate());
        return courseDto;
    }

    public static Course CourseDtoToCourseMapper(CourseDto courseDto) {
        return null;
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
