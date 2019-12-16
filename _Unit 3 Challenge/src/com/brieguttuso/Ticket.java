package com.brieguttuso;

public abstract class Ticket {

    MinMax minmaxbehavior;
    SpecialEvent specialeventbehavior;
    LostTicket lostticketbehavior;

    public Ticket() {


    }

    public abstract void display();

    public void performCalculation() {

        minmaxbehavior.calculateCharges();
    }

    public void setMinMax (MinMax mm) {

        minmaxbehavior = mm;
    }

    public void performSpecialEvent() {

        specialeventbehavior.calculateCharges();
    }

    public void showSpecialEventCharge() {

        specialeventbehavior.showCharges();
    }

    public void performLostTicket() {

        lostticketbehavior.calculateCharges();
    }

    public void performLostCalculationTotal() {

        lostticketbehavior.getTotalLostTicketCosts();
    }


}
