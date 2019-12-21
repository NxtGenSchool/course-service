package com.edu.school.courses.api.group;

import com.edu.school.courses.model.dto.group.EventDto;
import com.edu.school.courses.model.group.Event;
import com.edu.school.courses.service.group.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("courses/{courseId}/group/")
public class EventController {

    private EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping(path = "events", produces = APPLICATION_JSON_VALUE)
    public EventDto createEvent(@PathVariable Long courseId, @RequestBody EventDto eventDto) {
        Event newEvent = eventService.createEvent(courseId, EventDto.EventDtoToEventMapper(eventDto));
        return EventDto.EventToEventDtoMapper(newEvent);
    }

    @GetMapping(path = "events/{eventId}", produces = APPLICATION_JSON_VALUE)
    public EventDto getEvent(@PathVariable Long eventId) {
        Event event = eventService.getEvent(eventId);
        return EventDto.EventToEventDtoMapper(event);
    }

    @GetMapping(path = "events/all", produces = APPLICATION_JSON_VALUE)
    public List<EventDto> getAllEvent() {
        List<Event> events = eventService.getAllEvent();
        return EventDto.EventToEvenDtoMapper(events);
    }
}
