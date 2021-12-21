package com.rostertwo.springcorebooking;

import model.Ticket;

import java.util.ArrayList;
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
        return new ArrayList<>(tickets.values());
    }

    public void save(Ticket ticket) {
        tickets.put(ticket.getId(), ticket);
    }

    public void update(Ticket ticket, long eventId, long UserId, Ticket.Category category, int place) {
        ticket.setEventId(eventId);
        ticket.setUserId(UserId);
        ticket.setCategory(category);
        ticket.setPlace(place);
        tickets.put(ticket.getId(), ticket);
    }

    public void delete(long ticketId) {
        tickets.remove(ticketId);
    }
}
