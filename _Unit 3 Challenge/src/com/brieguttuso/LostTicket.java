package com.brieguttuso;

public class LostTicket implements FeeBehavior {

    public int calculateCharges() {

        int fee = 25;
        return fee;
        // Lost Ticket Charges
        //System.out.println("This will handle lost ticket charges");

    }

//        public int lostTicket() {
//        int fee = 25;
//        return fee;
//    }

        public void getTotalLostTicketCosts() {

        System.out.println("$" + calculateCharges() + " was collected from " + "Lost Tickets");
    }

}
