package com.edu.school.courses.api;

import com.edu.school.courses.model.Course;
import com.edu.school.courses.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class CourseController {

    private CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping(path = "courses/create" , produces = APPLICATION_JSON_VALUE)
    public Course createCourse(@RequestBody Course newCourse) {
        return courseService.createCourse(newCourse);
    }

    @GetMapping( path = "courses/{courseId}" , produces = APPLICATION_JSON_VALUE)
    public Course getCourse(@PathVariable Long courseId) {
        return courseService.getCourse(courseId);
    }

    public void updateCourse() {

    }

    public void deleteCourse() {

    }


}
