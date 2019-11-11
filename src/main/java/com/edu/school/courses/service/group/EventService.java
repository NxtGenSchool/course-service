package com.edu.school.courses.service.group;

import com.edu.school.courses.Repository.group.EventRepository;
import com.edu.school.courses.model.Course;
import com.edu.school.courses.model.group.Event;
import com.edu.school.courses.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    private EventRepository eventRepository;

    private CourseService courseService;

    @Autowired
    public EventService(EventRepository eventRepository, CourseService courseService) {
        this.eventRepository = eventRepository;
        this.courseService = courseService;
    }

    public Event createEvent(Long courseId, Event event) {
        Event newEvent = Event.getDuplicateInstance(event);
        Course course = courseService.getCourse(courseId);
        newEvent.setGroup(course.getGroup());
        return eventRepository.save(newEvent);
    }

    public Event getEvent(Long eventId) {
        return eventRepository.getOne(eventId);
    }

    public List<Event> getAllEvent() {
        return eventRepository.findAll();
    }
}
