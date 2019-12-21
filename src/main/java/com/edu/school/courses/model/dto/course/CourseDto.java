package com.edu.school.courses.model.dto.course;

import com.edu.school.courses.model.Course;
import com.edu.school.courses.model.CourseSchedule;
import com.edu.school.courses.model.group.Group;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CourseDto {

    private Long uidPk;

    private Group group;

    private LocalDate startDate;
    private LocalDate endDate;
    private List<CourseSchedule> courseSchedules;


    public static CourseDto CourseToCourseDtoMapper(Course course) {
        CourseDto courseDto = new CourseDto();
        if (course != null) {
            courseDto.setUidPk(course.getUidPk());
            courseDto.setGroup(course.getGroup());
            courseDto.setCourseSchedules(course.getCourseSchedules());
            courseDto.setStartDate(course.getStartDate());
            courseDto.setEndDate(course.getEndDate());
        }
        return courseDto;
    }

    public static Course CourseDtoToCourseMapper(CourseDto courseDto) {
        Course course = new Course();
        if (courseDto != null) {
            course.setGroup(courseDto.getGroup());
            course.setCourseSchedules(courseDto.getCourseSchedules());
            course.setUidPk(courseDto.getUidPk());
            course.setStartDate(courseDto.getStartDate());
            course.setEndDate(courseDto.getEndDate());
        }
        return course;
    }

    public static List<CourseDto> CourseToCourseDtoMapper(List<Course> courses) {
        List<CourseDto> courseDtoList = new ArrayList<>();
        for (Course course : courses) {
            CourseDto courseDto = new CourseDto();
            courseDto.setUidPk(course.getUidPk());
            courseDto.setGroup(course.getGroup());
            courseDto.setCourseSchedules(course.getCourseSchedules());
            courseDto.setStartDate(course.getStartDate());
            courseDto.setEndDate(course.getEndDate());
            courseDtoList.add(courseDto);
        }
        return courseDtoList;
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
