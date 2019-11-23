package com.edu.school.courses.Repository.dao.group;

import com.edu.school.courses.model.dto.group.EventDto;

import java.util.List;

public interface EventDao {

    EventDto createEvent(Long courseId, EventDto eventDto);

    EventDto getEvent(Long eventId);

    List<EventDto> getAllEvent();
}
