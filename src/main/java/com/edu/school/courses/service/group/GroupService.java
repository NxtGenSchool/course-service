package com.edu.school.courses.service.group;

import com.edu.school.courses.Repository.dao.group.GroupDao;
import com.edu.school.courses.exception.IllegalGroupException;
import com.edu.school.courses.model.Course;
import com.edu.school.courses.model.group.Group;
import com.edu.school.courses.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {

    private GroupDao groupDao;
    private CourseService courseService;

    @Autowired
    public GroupService(GroupDao groupDao, CourseService courseService) {
        this.groupDao = groupDao;
        this.courseService = courseService;
    }

    public Group createGroup(Long courseId, Group userGroup) {
        Course course = courseService.getCourse(courseId);
        if (course.getGroup() != null) {
            throw new IllegalGroupException("Group for this course already exists");
        }
        Group savedGroup = groupDao.saveGroup(userGroup);
        course.setGroup(savedGroup);
        courseService.updateCourse(course);
        return savedGroup;
    }

    public Group getGroup(Long groupId) {
        return groupDao.getGroup(groupId);
    }

    public List<Group> getAllGroup() {
        return groupDao.getAllGroups();
    }
}
