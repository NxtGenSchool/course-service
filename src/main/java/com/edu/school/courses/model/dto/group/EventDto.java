package com.edu.school.courses.model.dto.group;

import com.edu.school.courses.model.group.Author;
import com.edu.school.courses.model.group.Event;
import com.edu.school.courses.model.group.Group;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EventDto {

    private Long uidPk;
    private Group group;
    private Author author;
    private String title;
    private String Description;
    private String Location;
    private LocalDate Time;
    private LocalDate createdDate;

    public static EventDto getEventDtoInstance(EventDto eventDto) {
        EventDto newEventDto = new EventDto();
        newEventDto.setAuthor(eventDto.getAuthor());
        newEventDto.setCreatedDate(eventDto.getCreatedDate());
        newEventDto.setDescription(eventDto.getDescription());
        newEventDto.setLocation(eventDto.getLocation());
        newEventDto.setTitle(eventDto.getTitle());
        newEventDto.setTime(eventDto.getTime());
        newEventDto.setGroup(eventDto.getGroup());
        return newEventDto;
    }

    public static Event EventDtoToEventMapper(EventDto eventDto) {
        Event event = new Event();
        event.setAuthor(eventDto.getAuthor());
        event.setCreatedDate(eventDto.getCreatedDate());
        event.setDescription(eventDto.getDescription());
        event.setGroup(eventDto.getGroup());
        event.setLocation(eventDto.getLocation());
        event.setTime(eventDto.getTime());
        event.setTitle(eventDto.getTitle());
        event.setUidPk(eventDto.getUidPk());
        return event;

    }

    public static EventDto EventToEventDtoMapper(Event event) {
        EventDto eventDto = new EventDto();
        eventDto.setUidPk(event.getUidPk());
        eventDto.setTitle(event.getTitle());
        eventDto.setTime(event.getTime());
        eventDto.setLocation(event.getLocation());
        eventDto.setAuthor(event.getAuthor());
        eventDto.setCreatedDate(event.getCreatedDate());
        eventDto.setDescription(event.getDescription());
        eventDto.setGroup(event.getGroup());
        return eventDto;
    }

    public static List<EventDto> EventToEvenDtoMapper(List<Event> eventList) {
        List<EventDto> eventDtoList = new ArrayList<>();
        for (Event event : eventList) {
            EventDto eventDto = new EventDto();
            eventDto.setUidPk(event.getUidPk());
            eventDto.setGroup(event.getGroup());
            eventDto.setDescription(event.getDescription());
            eventDto.setCreatedDate(event.getCreatedDate());
            eventDto.setAuthor(event.getAuthor());
            eventDto.setLocation(event.getLocation());
            eventDto.setTime(event.getTime());
            eventDto.setTitle(event.getTitle());
            eventDtoList.add(eventDto);
        }
        return eventDtoList;
    }


    public Long getUidPk() {
        return uidPk;
    }

    public void setUidPk(Long uidPk) {
        this.uidPk = uidPk;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public LocalDate getTime() {
        return Time;
    }

    public void setTime(LocalDate time) {
        Time = time;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }
}
