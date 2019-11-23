package com.edu.school.courses.service.group;

import com.edu.school.courses.Repository.dao.group.EventDao;
import com.edu.school.courses.Repository.group.EventRepository;
import com.edu.school.courses.model.Course;
import com.edu.school.courses.model.dto.group.EventDto;
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

    public EventDto createEvent(Long courseId, EventDto event) {
        EventDto newEventDto = EventDto.getEventDtoInstance(event);
        Course course = courseService.getCourse(courseId);
        newEventDto.setGroup(course.getGroup());
        return eventDao.createEvent(courseId , newEventDto);
    }

    public EventDto getEvent(Long eventId) {
        return eventDao.getEvent(eventId);
    }

    public List<EventDto> getAllEvent() {
        return eventDao.getAllEvent();
    }
}
