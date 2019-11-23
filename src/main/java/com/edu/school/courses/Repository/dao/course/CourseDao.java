package com.edu.school.courses.Repository.dao.course;

import com.edu.school.courses.model.Course;
import com.edu.school.courses.model.dto.course.CourseDto;

import java.util.List;

public interface CourseDao {

    CourseDto getCourse(Long courseId);
    CourseDto createCourse(CourseDto courseDto);
    List<CourseDto> getAllCourses();
    CourseDto updateCourse(CourseDto courseDto);
    void deleteCourse(Long courseId);
}
