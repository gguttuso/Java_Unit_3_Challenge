package com.brieguttuso;

public class SpecialEvent implements FeeBehavior {

    public int calculateCharges() {

        int fee = 20;
        return fee;

    }

    public void showCharges() {

        System.out.println("There is a $" + calculateCharges() + " flat fee.");
    }
}
