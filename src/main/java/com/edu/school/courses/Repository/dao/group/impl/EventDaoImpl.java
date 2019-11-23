package com.edu.school.courses.Repository.dao.group.impl;

import com.edu.school.courses.Repository.dao.group.EventDao;
import com.edu.school.courses.Repository.group.EventRepository;
import com.edu.school.courses.model.dto.group.EventDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EventDaoImpl implements EventDao {

    private EventRepository eventRepository;

    @Autowired
    public EventDaoImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public EventDto createEvent(Long courseId, EventDto eventDto) {
        return null;
    }

    @Override
    public EventDto getEvent(Long eventId) {
        return null;
    }

    @Override
    public List<EventDto> getAllEvent() {
        return null;
    }
}
