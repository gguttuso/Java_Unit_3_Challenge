package com.brieguttuso;

import java.util.Random;

public class CheckOut {

    public CheckOut() {
    }

    // generate random number between 1 and 11 for check in time (range is military time 13-23)
    public int getRandomNumber() {

        Random random = new Random();
        int randomNumber = random.nextInt(23 - 13 + 1) + 13;
        // this is the syntax
        // random.nextInt(max-min_ + 1) + min;

        //System.out.println(randomNumber);
        return randomNumber;

    }
}
