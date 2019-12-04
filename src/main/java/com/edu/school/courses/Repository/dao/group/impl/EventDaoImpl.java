package com.edu.school.courses.Repository.dao.group.impl;

import com.edu.school.courses.Repository.dao.group.EventDao;
import com.edu.school.courses.Repository.group.EventRepository;
import com.edu.school.courses.model.group.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EventDaoImpl implements EventDao {

    private EventRepository eventRepository;

    @Autowired
    public EventDaoImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public Event createEvent(Long courseId, Event event) {
        Event newEvent = eventRepository.save(event);
        return newEvent;
    }

    @Override
    public Event getEvent(Long eventId) {
        Event event = eventRepository.getOne(eventId);
        return event;
    }

    @Override
    public List<Event> getAllEvent() {
        List<Event> events = eventRepository.findAll();
        return events;
    }
}
