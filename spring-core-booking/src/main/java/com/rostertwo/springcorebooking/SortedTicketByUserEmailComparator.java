package com.rostertwo.springcorebooking;

import model.Ticket;

import java.util.Comparator;

public class SortedTicketByUserEmailComparator implements Comparator<Ticket> {

    private UserService userService;

    @Override
    public int compare(Ticket t1, Ticket t2) {
        return userService.getUserById(t2.getUserId()).getEmail().compareTo(userService.getUserById(t1.getUserId()).getEmail());
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
