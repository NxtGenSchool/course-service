package com.edu.school.courses.api;

import com.edu.school.courses.model.Course;
import com.edu.school.courses.model.dto.course.CourseDto;
import com.edu.school.courses.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("courses")
public class CourseController {

    private CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping(path = "/create" , produces = APPLICATION_JSON_VALUE)
    public CourseDto createCourse(@RequestBody CourseDto userCourseDto) {
        Course userCourse = CourseDto.CourseDtoToCourseMapper(userCourseDto);
        Course newCourse = courseService.createCourse(userCourse);
        return CourseDto.CourseToCourseDtoMapper(newCourse);
    }

    @GetMapping( path = "/{courseId}" , produces = APPLICATION_JSON_VALUE)
    public CourseDto getCourse(@PathVariable Long courseId) {
        Course course = courseService.getCourse(courseId);
        return CourseDto.CourseToCourseDtoMapper(course);
    }

    @GetMapping( path = "/all" , produces = APPLICATION_JSON_VALUE)
    public List<CourseDto> getAllCourse() {
        List<Course> courses = courseService.getAllCourses();
        return CourseDto.CourseToCourseDtoMapper(courses);
    }

    @PutMapping( path = "/{courseId}" , produces = APPLICATION_JSON_VALUE)
    public CourseDto updateCourse(@RequestBody CourseDto courseDto) {
        Course course = CourseDto.CourseDtoToCourseMapper(courseDto);
        Course updatedCourse = courseService.updateCourse(course);
        return CourseDto.CourseToCourseDtoMapper(updatedCourse);
    }

    @DeleteMapping( path = "/{courseId}" , produces = APPLICATION_JSON_VALUE)
    public void deleteCourse(@PathVariable Long courseId) {
        courseService.deleteCourse( courseId );
    }


}
