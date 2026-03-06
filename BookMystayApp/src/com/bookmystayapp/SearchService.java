package com.bookmystayapp;

public class SearchService {

    private InventoryService inventory;

    public SearchService(InventoryService inventory) {
        this.inventory = inventory;
    }

    public void searchRoom(String type) {

        int available = inventory.getAvailableRooms(type);

        if(available > 0)
            System.out.println(type + " rooms available: " + available);
        else
            System.out.println("No rooms available for " + type);
    }
}