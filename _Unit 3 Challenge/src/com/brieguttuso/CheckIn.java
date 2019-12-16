package com.brieguttuso;

import java.util.Random;

public class CheckIn {

    public CheckIn() {
    }

    // generate random number between 7 and 12 for check in time
    public int getRandomNumber() {

        Random random = new Random();
        int randomNumber = random.nextInt(12-7 + 1) + 7;
        // this is the syntax
        // random.nextInt(max-min_ + 1) + min;

        System.out.println(randomNumber);
        return randomNumber;

    }


}
