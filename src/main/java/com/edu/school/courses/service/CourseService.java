package com.edu.school.courses.service;

import com.edu.school.courses.Repository.CourseRepository;
import com.edu.school.courses.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    private CourseRepository repository;

    @Autowired
    public CourseService(CourseRepository repository) {
        this.repository = repository;
    }

    public Course getCourse(Long courseId) {
        return  repository.getOne(courseId);
    }

    public Course createCourse ( Course newCourse) {
        return repository.save(newCourse);
    }

    public List<Course> getAllCourses() {
        return repository.findAll();
    }

    public Course updateCourse(Course course) {
        return repository.existsById(course.getUidPk()) ? repository.save(course) : null;
    }
}
