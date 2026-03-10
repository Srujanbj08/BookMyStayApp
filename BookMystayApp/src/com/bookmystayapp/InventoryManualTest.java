package com.bookmystayapp;

public class InventoryManualTest {

    public static void main(String[] args) {

        InventoryService inventory = new InventoryService();

        inventory.addRoomType("Single", 5, 2000);

        if(inventory.getAvailableRooms("Single") == 5) {
            System.out.println("TEST PASSED");
        }
        else {
            System.out.println("TEST FAILED");
        }
    }
}
