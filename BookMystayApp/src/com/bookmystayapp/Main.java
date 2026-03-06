package com.bookmystayapp;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // -------- UC1 : Inventory Setup --------
        InventoryService inventory = new InventoryService();

        inventory.addRoomType("Single", 5, 2000);
        inventory.addRoomType("Double", 3, 3500);
        inventory.addRoomType("Suite", 2, 6000);

        System.out.println("Room Inventory:");
        inventory.displayInventory();


        // -------- UC2 : Room Search --------
        SearchService search = new SearchService(inventory);

        System.out.print("\nEnter Room Type to Search: ");
        String type = sc.nextLine();

        search.searchRoom(type);


        // -------- UC3 : Booking Request Queue --------
        BookingQueueService queue = new BookingQueueService();

        System.out.print("\nEnter number of booking requests: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= n; i++) {

            System.out.println("\nBooking Request " + i);

            System.out.print("Enter Reservation ID: ");
            String id = sc.nextLine();

            System.out.print("Enter Room Type: ");
            String roomType = sc.nextLine();

            Reservation reservation = new Reservation(id, roomType);

            queue.addBookingRequest(reservation);

            try {
                Thread.sleep(2000); // simulate request arrival delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        // -------- UC4 : Reservation Confirmation --------
        BookingService bookingService = new BookingService(inventory);

        System.out.println("\nProcessing Booking Requests (FIFO):");

        Reservation r;

        while ((r = queue.getNextRequest()) != null) {

            System.out.println("\nProcessing Reservation: " + r.getReservationId());

            bookingService.confirmReservation(r);

            try {
                Thread.sleep(3000); // simulate processing delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("\nUpdated Inventory:");
        inventory.displayInventory();

        sc.close();
    }
}