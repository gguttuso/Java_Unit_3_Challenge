package com.brieguttuso;

public class SpecialEventTicket extends Ticket{

    public SpecialEventTicket() {
        // creating instances of the behavior instances variables in the Ticket Class
        specialeventbehavior = new SpecialEvent();
    }


    public void display() {

        System.out.println("This is a special event ticket");

    }
}
