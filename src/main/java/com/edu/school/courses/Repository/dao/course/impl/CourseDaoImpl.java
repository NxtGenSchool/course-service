package com.edu.school.courses.Repository.dao.course.impl;

import com.edu.school.courses.Repository.CourseRepository;
import com.edu.school.courses.Repository.dao.course.CourseDao;
import com.edu.school.courses.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CourseDaoImpl implements CourseDao {

    private CourseRepository courseRepository;

    @Autowired
    public CourseDaoImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public Course getCourse(Long courseId) {
        Course course = courseRepository.getOne(courseId);
        return course;
    }

    @Override
    public Course createCourse(Course course) {
        Course newCourse = courseRepository.save(course);
        return newCourse;
    }

    @Override
    public List<Course> getAllCourses() {
        List<Course> courses = courseRepository.findAll();
        return courses;
    }

    @Override
    public Course updateCourse(Course course) {
        Course updatedCourse = courseRepository.save(course);
        return updatedCourse;
    }

    @Override
    public void deleteCourse(Long courseId) {
        courseRepository.deleteById(courseId);
    }
}
