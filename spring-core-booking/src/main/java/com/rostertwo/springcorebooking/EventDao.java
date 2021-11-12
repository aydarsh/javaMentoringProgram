package com.rostertwo.springcorebooking;

import model.Event;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EventDao {
    private Map<Long, Event> events;

    public void setEvents(Map<Long, Event> events) {
        this.events = events;
    }

    public Event get(long id) {
        return events.get(id);
    }

    public List<Event> getAll() {
        return new ArrayList<>(events.values());
    }

    public void save(Event event) {
        events.put(event.getId(), event);
    }

    public void update(Event event, String title, Date date) {
        event.setTitle(title);
        event.setDate(date);
        events.put(event.getId(), event);
    }

    public void delete(long eventId) {
        events.remove(eventId);
    }
}
