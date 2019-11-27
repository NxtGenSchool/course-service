package com.edu.school.courses.Repository.dao.group.impl;

import com.edu.school.courses.Repository.dao.group.EventDao;
import com.edu.school.courses.Repository.group.EventRepository;
import com.edu.school.courses.model.dto.group.EventDto;
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
    public EventDto createEvent(Long courseId, EventDto eventDto) {
        Event newEvent = EventDto.EventDtoToEventMapper(EventDto.getEventDtoInstance(eventDto));
        return EventDto.EventToEventDtoMapper(eventRepository.save(newEvent));
    }

    @Override
    public EventDto getEvent(Long eventId) {
        return EventDto.EventToEventDtoMapper(eventRepository.getOne(eventId));
    }

    @Override
    public List<EventDto> getAllEvent() {
        return EventDto.EventToEvenDtoMapper(eventRepository.findAll());
    }
}
