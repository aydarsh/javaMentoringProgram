package com.rostertwo.springcorebooking;

import model.Ticket;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TicketDao{
    private Map<Long, Ticket> tickets;

    public void setTickets(Map<Long, Ticket> tickets) {
        this.tickets = tickets;
    }

    public Ticket get(long id) {
        return tickets.get(id);
    }

    public List<Ticket> getAll() {
        return tickets
                .values()
                .stream()
                .collect(Collectors.toList());
    }

    public void save(Ticket ticket) {
        if (ticket != null) {
            tickets.put(ticket.getId(), ticket);
        }
    }

    public void update(Ticket ticket, long eventId, long UserId, Ticket.Category category, int place) {
        if (ticket != null) {
            ticket.setEventId(eventId);
            ticket.setUserId(UserId);
            ticket.setCategory(category);
            ticket.setPlace(place);
            tickets.put(ticket.getId(), ticket);
        }
    }

    public void delete(long ticketId) {
        if (tickets.containsKey(ticketId)) {
            tickets.remove(ticketId);
        }
    }
}
