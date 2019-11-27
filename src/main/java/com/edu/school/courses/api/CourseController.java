package com.edu.school.courses.api;

import com.edu.school.courses.model.dto.course.CourseDto;
import com.edu.school.courses.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class CourseController {

    private CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping(path = "courses/create" , produces = APPLICATION_JSON_VALUE)
    public CourseDto createCourse(@RequestBody CourseDto newCourseDto) {
        return courseService.createCourse(newCourseDto);
    }

    @GetMapping( path = "courses/{courseId}" , produces = APPLICATION_JSON_VALUE)
    public CourseDto getCourse(@PathVariable Long courseId) {
        return courseService.getCourse(courseId);
    }

    @GetMapping( path = "courses/all" , produces = APPLICATION_JSON_VALUE)
    public List<CourseDto> getAllCourse() {
        return courseService.getAllCourses();
    }

    @PutMapping( path = "courses/{courseId}" , produces = APPLICATION_JSON_VALUE)
    public CourseDto updateCourse(@RequestBody CourseDto courseDto) {
        return courseService.updateCourse(courseDto);
    }

    @DeleteMapping( path = "courses/{courseId}" , produces = APPLICATION_JSON_VALUE)
    public void deleteCourse(@PathVariable Long courseId) {
        courseService.deleteCourse( courseId );
    }


}
