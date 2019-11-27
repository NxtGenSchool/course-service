package com.edu.school.courses.service;

import com.edu.school.courses.Repository.dao.course.CourseDao;
import com.edu.school.courses.model.dto.course.CourseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    private CourseDao courseDao;

    @Autowired
    public CourseService(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    public CourseDto getCourse(Long courseId) {
        return courseDao.getCourse(courseId);
    }

    public CourseDto createCourse(CourseDto course) {
        return courseDao.createCourse(course);
    }

    public List<CourseDto> getAllCourses() {
        return courseDao.getAllCourses();
    }

    public CourseDto updateCourse(CourseDto courseDto) {
        return courseDao.updateCourse(courseDto);
    }

    public void deleteCourse(Long courseId) {
        courseDao.deleteCourse(courseId);
    }
}
