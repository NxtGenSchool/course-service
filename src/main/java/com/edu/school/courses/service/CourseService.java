package com.edu.school.courses.service;

import com.edu.school.courses.Repository.dao.course.CourseDao;
import com.edu.school.courses.model.Course;
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

    public Course getCourse(Long courseId) {
        Course course = courseDao.getCourse(courseId);
        return course;
    }

    public Course createCourse(Course course) {
        Course newCourse = courseDao.createCourse(course);
        return newCourse;
    }

    public List<Course> getAllCourses() {
        List<Course> courses = courseDao.getAllCourses();
        return courses;
    }

    public Course updateCourse(Course course) {
        Course updatedCourse = courseDao.updateCourse(course);
        return updatedCourse;
    }

    public void deleteCourse(Long courseId) {
        courseDao.deleteCourse(courseId);
    }
}
