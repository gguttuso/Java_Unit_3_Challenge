package com.brieguttuso;

import java.util.Scanner;

public class MachineFactory {

    public void displayMachine (String input) {

        if (input.equals("1"))
        {
            displayCheckInMachine();
        }

        else if(input.equals("2")){

            displayCheckOutMachine();
        }

    }

    public void displayCheckInMachine() {

        System.out.println("Best Value Parking Garage");
        System.out.println("=========================");
        System.out.println("1. Check In");
        System.out.println("2. Special Event");
        System.out.println("3. Close Garage");

    }

    public void displayCheckOutMachine() {

        System.out.println("Best Value Parking Garage");
        System.out.println("=========================");
        System.out.println("1. Check Out");
        System.out.println("2. Lost Ticket");

    }
}
