package com.bookmystayapp;

public class FailedTestCase {

    public static void main(String[] args) {

        InventoryService inventory = new InventoryService();

        inventory.addRoomType("Single", 5, 2000);

        // Wrong expected value intentionally
        if(inventory.getAvailableRooms("Single") == 10) {
            System.out.println("TEST PASSED");
        }
        else {
            System.out.println("TEST FAILED");
        }
    }
}
