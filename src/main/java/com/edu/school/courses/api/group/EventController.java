package com.edu.school.courses.api.group;

import com.edu.school.courses.model.group.Event;
import com.edu.school.courses.service.group.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class EventController {

    private EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping(path = "events/create", produces = APPLICATION_JSON_VALUE)
    public Event createEvent() {
        return eventService.createEvent();
    }

    @GetMapping(path = "events/{eventId}", produces = APPLICATION_JSON_VALUE)
    public Event getEvent(@PathVariable Long eventId) {
        return eventService.getEvent(eventId);
    }

    @GetMapping(path = "events/all", produces = APPLICATION_JSON_VALUE)
    public List<Event> getAllEvent() {
        return eventService.getAllEvent();
    }
}
