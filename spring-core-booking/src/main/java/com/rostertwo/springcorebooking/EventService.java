package com.rostertwo.springcorebooking;

import model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class EventService {

    @Autowired
    private EventDao eventDao;

    public EventService(EventDao eventDao) {
        this.eventDao = eventDao;
    }

    public Event getEventById(long eventId) {
        return eventDao.get(eventId);
    }

    public List<Event> getEventsByTitle(String title, int pageSize, int pageNum) {
        return eventDao
                .getAll()
                .stream()
                .filter((s) -> s.getTitle().contains(title))
                .collect(Collectors.toList());
    }

    public List<Event> getEventsForDay(Date day, int pageSize, int pageNum) {
        return eventDao
                .getAll()
                .stream()
                .filter((s) -> day.equals(s.getDate()))
                .collect(Collectors.toList());
    }

    public Event createEvent(Event event) {
        eventDao.save(event);
        return event;
    }

    public Event updateEvent(Event event, String title, Date date) {
        eventDao.update(event, title, date);
        return event;
    }

    public boolean deleteEvent(long eventId) {
        eventDao.delete(eventId);
        return true;
    }
}
