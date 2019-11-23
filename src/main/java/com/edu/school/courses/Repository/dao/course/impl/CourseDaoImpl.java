package com.edu.school.courses.Repository.dao.course.impl;

import com.edu.school.courses.Repository.CourseRepository;
import com.edu.school.courses.Repository.dao.course.CourseDao;
import com.edu.school.courses.model.dto.course.CourseDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CourseDaoImpl implements CourseDao {

    private CourseRepository courseRepository;

    @Autowired
    public CourseDaoImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public CourseDto getCourse(Long courseId) {
        return null;
    }

    @Override
    public CourseDto createCourse(CourseDto courseDto) {
        return null;
    }

    @Override
    public List<CourseDto> getAllCourses() {
        return null;
    }

    @Override
    public CourseDto updateCourse(CourseDto courseDto) {
        return null;
    }

    @Override
    public void deleteCourse(Long courseId) {

    }
}
