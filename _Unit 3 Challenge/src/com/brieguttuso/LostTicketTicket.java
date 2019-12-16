package com.brieguttuso;

public class LostTicketTicket extends Ticket {

    public LostTicketTicket() {
        // creating instances of the behavior instances variables in the Ticket Class
        lostticketbehavior = new LostTicket();
    }

    public void display() {

        System.out.println("This is a lost ticket.");

    }
}
