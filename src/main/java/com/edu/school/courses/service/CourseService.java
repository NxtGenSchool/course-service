package com.edu.school.courses.service;

import com.edu.school.courses.Repository.CourseRepository;
import com.edu.school.courses.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}