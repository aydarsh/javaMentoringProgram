package com.rostertwo.springcorebooking;

import facade.BookingFacade;
import model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class SpringCoreBookingApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("simple-booking-facade-config.xml");
        BookingFacade bookingFacade = applicationContext.getBean(BookingFacade.class);

        List<User> usersAidar = bookingFacade.getUsersByName("aidar", 5, 0);
        usersAidar.stream().forEach((s) -> System.out.println(s.getName() + ": " + s.getEmail()));
    }
}
