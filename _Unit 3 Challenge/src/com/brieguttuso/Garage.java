package com.brieguttuso;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Garage {

    /**
     *
     * @author BrieGuttuso
     * This is the garage class that runs most of the program
     */

    Scanner keyboard = new Scanner(System.in);

    // reference the machine factory
    private MachineFactory factory;

    Ticket specialEventTicket = new SpecialEventTicket();
    Ticket lostTicket = new LostTicketTicket();

    // we created this for a singleton, only can create one garage
    private static Garage instance;

    // gets the factory passed to it in the constructor
    public Garage(MachineFactory factory){
        this.factory = factory;
    }

    public void displayMachine(String input){

        factory.displayMachine(input);

    }

//    public String getUserInput() {
//
//        String input = keyboard.nextLine();
//        return input;
//
//    }

    public void checkUserInput() throws IOException {

        boolean moreChoices = true;

        while(moreChoices) {

            int input = keyboard.next().charAt(0);

            switch (input) {

                case '1':
                    writeFile();
                    readFile();
                    checkOutChoice();
                    break;
                // after 1 is selected, random check in time is triggered
                // after 1 is selected, "vehicle XX checks in"
                // then checkout screen is displayed

                case '2':
                    specialEventTicket.performSpecialEvent();
                    specialEventTicket.showSpecialEventCharge();
                    break;

                default: moreChoices = false;
                    break;

            }
        }


    }

    // get check out screen user input
    public char getUserInputCheckOut() {

        Scanner keyboard = new Scanner(System.in);
        String checkOutInput = keyboard.nextLine();
        return checkOutInput.charAt(0);
    }

    public void checkOutChoice() throws IOException {

        boolean moreChoices = true;

        while(moreChoices){

            displayMachine("2");
            char choice = getUserInputCheckOut();
            switch (choice) {

                case '1':

                    displayMachine("1");
                    // need to add vehicle id here
                    System.out.println("Receipt for vehicle id " + displayVehicleID());
                    System.out.println();
                    displayHoursParked();
                    displayMoneyOwed();
                    System.out.println();


                    displayMachine("1");
                    choice = keyboard.next().charAt(0);

                    switch(choice) {

                        case '1':
                            writeFile();
                            readFile();
                            checkOutChoice();
                            break;
                        // after 1 is selected, random check in time is triggered
                        // after 1 is selected, "vehicle XX checks in"
                        // then checkout screen is displayed

                        case '3':
                            displayMachine("1");
                            System.out.println("\n Activity to Date");
                            getTotalCollectionCheckInCosts();
                            lostTicket.performLostCalculationTotal();
                            break;

                        default: moreChoices = false;
                            break;
                    }

                    break;
                case '2': lostTicket.performLostTicket();
                    // write method here that will display bill
                    System.out.println("Lost ticket $25.00");
                    break;
                default: moreChoices = false;
                    break;
            }
        }
    }

    // this is a singleton
    //Garage garage = Garage.getInstance();

    public static Garage getInstance(MachineFactory machineFactory) {

        if (instance == null) {
            instance = new Garage(machineFactory);
        }

        return instance;
    }

    public void createFile() throws IOException {

        // new file to be created
        File file = new File("ticketfile.txt");

        //checking if file exists, if yes - display file name
        // if not - display file already exists
        if(file.createNewFile())
        {
            System.out.println("File created: " + file.getName());
        }

        else {

            System.out.println("File already exists");
        }

    }

    public void writeFile() throws IOException {

        createFile();
        FileWriter myWriter = new FileWriter("ticketfile.txt");
        myWriter.write("Vehicle 1 checks in");

        ArrayList<Menu1> menu = new ArrayList<>();

        // add pizza to main course
        // pass in name(string), ingredients(string array), instructions(string) and points(int)
        menu.add(new Menu1("Vehicle", displayVehicleID(), " checks in"));

        myWriter.close();
        System.out.println("Successfully wrote to the file.");

    }

    public void readFile() throws FileNotFoundException {

        File file = new File("ticketfile.txt");
        Scanner myReader = new Scanner(file);
        while(myReader.hasNextLine()){

            String data = myReader.nextLine();
            System.out.println(data);

        }

    }

    public int generateVehicleID(){

        // generate vehicle id
        int vehicleID = 1;
        return vehicleID;

    }

    public int displayVehicleID() {

        int vehicleID = generateVehicleID();
        return vehicleID;

    }

    public void displayReceipt() {

        System.out.println("Receipt for vehicle id " + generateVehicleID());
    }


    CheckIn checkIn = new CheckIn();
    CheckOut checkOut = new CheckOut();


    // calculate hours parked
    public int calculateHoursParked() {


        int checkInNumber = checkIn.getRandomNumber();
        int checkOutNumber = checkOut.getRandomNumber();

        int hoursParked =  checkOutNumber - checkInNumber;
        return hoursParked;

    }

    public void displayHoursParked() {

        int checkInNumber = checkIn.getRandomNumber();
        int checkOutNumber = checkOut.getRandomNumber();

        System.out.println(calculateHoursParked() + " hours parked " + checkInNumber + "am "
                + "to " + (checkOutNumber-12) + "pm");

    }

    // calculate money owed
    public int calculateMoneyOwed() {

        int fee = 0;

        if(calculateHoursParked()<= 3) {
            fee = calculateHoursParked() * 5;
            // if parked 4 hours it would be $5 for three hours and then $1 more dollar = $6
            // 4 hours = $6.00
            // max charge is $15.00
        }
        else if(calculateHoursParked() >= 4)
        {
            int hoursAfterThree = (calculateHoursParked() - 3) + 1;
            fee = hoursAfterThree + 4;
        }

        else if(calculateHoursParked() >= 13)
        {
            fee = 15;
        }

        return fee;
    }


// MOVED TO LOST TICKET
//    public int lostTicket() {
//        int fee = 25;
//        return fee;
//    }

    // display money owed
    public void displayMoneyOwed() {
        System.out.println("You owe $" + calculateMoneyOwed());
    }

    public void getTotalCollectionCheckInCosts() {

        System.out.println("$" + calculateMoneyOwed() + " was collected from " + "Check Ins");
    }


// MOVED TO LOST TICKET
//    public void getTotalLostTicketCosts() {
//
//        System.out.println("$" + lostTicket() + " was collected from " + "Lost Tickets");
//    }

    public void getCollectedOverall() {

        System.out.println("was collected overall");
    }

    public void readFromFile() throws FileNotFoundException {

        File file = new File("ticketfile.txt");
        Scanner scan = new Scanner(file);
        System.out.println(scan.nextLine());

    }

}
