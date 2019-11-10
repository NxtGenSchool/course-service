package com.edu.school.courses.service.group;

import com.edu.school.courses.Repository.group.EventRepository;
import com.edu.school.courses.model.group.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    private EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Event createEvent() {
        return eventRepository.save(new Event());
    }

    public Event getEvent(Long eventId) {
        return eventRepository.getOne(eventId);
    }

    public List<Event> getAllEvent() {
        return eventRepository.findAll();
    }
}
