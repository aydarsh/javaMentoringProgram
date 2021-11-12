package com.rostertwo.springcorebooking;

import model.Ticket;

import java.util.Comparator;

public class ReverseTicketByDateComparator implements Comparator<Ticket> {

    private EventService eventService;

    @Override
    public int compare(Ticket t1, Ticket t2) {
        return eventService.getEventById(t2.getEventId()).getDate().compareTo(eventService.getEventById(t1.getEventId()).getDate());
    }

    public void setEventService(EventService eventService) {
        this.eventService = eventService;
    }
}
