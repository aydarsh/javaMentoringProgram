package com.rostertwo.springcorebooking;

import model.Event;
import model.Ticket;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TicketService {

    @Autowired
    private TicketDao ticketDao;

    private ReverseTicketByDateComparator reverseTicketByDateComparator;

    private SortedTicketByUserEmailComparator sortedTicketByUserEmailComparator;

    public TicketService(TicketDao ticketDao) {
        this.ticketDao = ticketDao;
    }

    public Ticket bookTicket(long userId, long eventId, int place, Ticket.Category category) {
        Ticket ticket = new SimpleTicket(eventId, userId, category, place);
        ticketDao.save(ticket);
        return ticket;
    }

    /**
     * Get all booked tickets for specified user. Tickets should be sorted by event date in descending order.
     * @param user User
     * @param pageSize Pagination param. Number of tickets to return on a page.
     * @param pageNum Pagination param. Number of the page to return. Starts from 1.
     * @return List of Ticket objects.
     */
    public List<Ticket> getBookedTickets(User user, int pageSize, int pageNum) {

        return ticketDao
                .getAll()
                .stream()
                .filter((s) -> user.getId() == s.getUserId())
//                .sorted(Comparator.comparing(Ticket::getEventId, Comparator.reverseOrder()))
                .sorted(reverseTicketByDateComparator)
                .collect(Collectors.toList());
    }

    /**
     * Get all booked tickets for specified event. Tickets should be sorted in by user email in ascending order.
     * @param event Event
     * @param pageSize Pagination param. Number of tickets to return on a page.
     * @param pageNum Pagination param. Number of the page to return. Starts from 1.
     * @return List of Ticket objects.
     */
    public List<Ticket> getBookedTickets(Event event, int pageSize, int pageNum) {

        return ticketDao
                .getAll()
                .stream()
                .filter((s) -> event.getId() == s.getEventId())
                .sorted(sortedTicketByUserEmailComparator)
                .collect(Collectors.toList());
    }

    public boolean cancelTicket(long ticketId) {
        ticketDao.delete(ticketId);
        return true;
    }

    public void setReverseTicketByDateComparator(ReverseTicketByDateComparator reverseTicketByDateComparator) {
        this.reverseTicketByDateComparator = reverseTicketByDateComparator;
    }

    public void setSortedTicketByUserEmailComparator(SortedTicketByUserEmailComparator sortedTicketByUserEmailComparator) {
        this.sortedTicketByUserEmailComparator = sortedTicketByUserEmailComparator;
    }
}
