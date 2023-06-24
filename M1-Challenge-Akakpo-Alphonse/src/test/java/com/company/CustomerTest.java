package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerTest {

    @Test
    public void testGetBalance() {
        // Create a customer
        Customer customer = new Customer();

        // Add account records
        AccountRecord record1 = new AccountRecord();
        record1.setCharge(1000);
        customer.getCharges().add(record1);

        AccountRecord record2 = new AccountRecord();
        record2.setCharge(-500);
        customer.getCharges().add(record2);

        AccountRecord record3 = new AccountRecord();
        record3.setCharge(200);
        customer.getCharges().add(record3);

        // Test getBalance() method
        int expectedBalance = 700; // 1000 - 500 + 200 = 700
        int actualBalance = customer.getBalance();
        assertEquals(expectedBalance, actualBalance);
    }

    @Test
    public void testToString() {
        // Create a customer
        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("Wayne Enterprises");

        // Test toString() method
        String expectedString = "Customer ID: 1, Name: Wayne Enterprises, Balance: 0";
        String actualString = customer.toString();
        assertEquals(expectedString, actualString);
    }
}
