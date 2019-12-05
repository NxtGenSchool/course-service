package com.edu.school.courses.service.group;

import com.edu.school.courses.Repository.dao.group.EventDao;
import com.edu.school.courses.model.Course;
import com.edu.school.courses.model.group.Event;
import com.edu.school.courses.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    private EventDao eventDao;

    private CourseService courseService;

    @Autowired
    public EventService( EventDao eventDao, CourseService courseService) {
        this.eventDao = eventDao;
        this.courseService = courseService;
    }

    public Event createEvent(Long courseId, Event event) {
        Course course = courseService.getCourse(courseId);
        event.setGroup(course.getGroup());
        Event newEvent = eventDao.createEvent(courseId, event);
        return newEvent;
    }

    public Event getEvent(Long eventId) {
        return eventDao.getEvent(eventId);
    }

    public List<Event> getAllEvent() {
        List<Event> events = eventDao.getAllEvent();
        return events;
    }
}
