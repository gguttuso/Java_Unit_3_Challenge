package com.brieguttuso;

import org.junit.Test;

import static org.junit.Assert.*;

public class GarageTest {

    @Test
    public void calculateHoursParkedTest() {

        int checkInNumber = 3;
        int checkOutNumber = 5;

        int hoursParked = checkOutNumber - checkInNumber;

        assertEquals(2, hoursParked, 0);
    }


}