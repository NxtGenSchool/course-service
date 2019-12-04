package com.edu.school.courses.Repository.dao.group;

import com.edu.school.courses.model.group.Event;

import java.util.List;

public interface EventDao {

    Event createEvent(Long courseId, Event event);

    Event getEvent(Long eventId);

    List<Event> getAllEvent();
}
