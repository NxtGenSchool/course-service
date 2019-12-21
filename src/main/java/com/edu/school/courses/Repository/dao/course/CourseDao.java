package com.edu.school.courses.Repository.dao.course;

import com.edu.school.courses.model.Course;

import java.util.List;

public interface CourseDao {

    Course getCourse(Long courseId);

    Course createCourse(Course course);

    List<Course> getAllCourses();

    Course updateCourse(Course course);
    void deleteCourse(Long courseId);
}
