package com.edu.school.courses.Repository.dao.course.impl;

import com.edu.school.courses.Repository.CourseRepository;
import com.edu.school.courses.Repository.dao.course.CourseDao;
import com.edu.school.courses.model.dto.course.CourseDto;
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
    public CourseDto getCourse(Long courseId) {
        return CourseDto.CourseToCourseDtoMapper(courseRepository.getOne(courseId));
    }

    @Override
    public CourseDto createCourse(CourseDto courseDto) {
        return CourseDto.CourseToCourseDtoMapper(courseRepository.save(CourseDto.CourseDtoToCourseMapper(courseDto)));
    }

    @Override
    public List<CourseDto> getAllCourses() {
        return CourseDto.CourseToCourseDtoMapper(courseRepository.findAll());
    }

    @Override
    public CourseDto updateCourse(CourseDto courseDto) {
        return CourseDto.CourseToCourseDtoMapper(courseRepository.save(CourseDto.CourseDtoToCourseMapper(courseDto)));
    }

    @Override
    public void deleteCourse(Long courseId) {
        courseRepository.deleteById(courseId);
    }
}
