package com.brieguttuso;

import java.io.IOException;

public class Main {

    /**
     *
     * @author BrieGuttuso
     * This is the main driver class
     */

    public static void main(String[] args) throws IOException {

        MachineFactory machineFactory = new MachineFactory();
        Garage garage = Garage.getInstance(machineFactory);

        garage.displayMachine("1");
        garage.checkUserInput();

    }
}
