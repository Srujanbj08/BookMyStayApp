package com.bookmystayapp;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        InventoryService inventory = new InventoryService();

        inventory.addRoomType("Single", 5, 2000);
        inventory.addRoomType("Double", 3, 3500);
        inventory.addRoomType("Suite", 2, 6000);

        System.out.println("Room Inventory:");
        inventory.displayInventory();

        SearchService search = new SearchService(inventory);

        System.out.print("\nEnter Room Type to Search: ");
        String type = sc.nextLine();

        search.searchRoom(type);

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
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        BookingService bookingService = new BookingService(inventory);
        BookingHistory history = new BookingHistory();

        System.out.println("\nProcessing Booking Requests (FIFO):");

        Reservation r;

        while ((r = queue.getNextRequest()) != null) {

            System.out.println("\nProcessing Reservation: " + r.getReservationId());

            bookingService.confirmReservation(r);

            history.addReservation(r);

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("\nUpdated Inventory:");
        inventory.displayInventory();

        ServiceManager manager = new ServiceManager();

        System.out.println("\nAdd Service to Reservation");

        System.out.print("Enter Reservation ID: ");
        String reservationId = sc.nextLine();

        System.out.print("Enter Service Name: ");
        String serviceName = sc.nextLine();

        System.out.print("Enter Service Price: ");
        double price = sc.nextDouble();

        Service service = new Service(serviceName, price);

        manager.addService(reservationId, service);

        System.out.println("\nServices for Reservation " + reservationId + ":");
        manager.showServices(reservationId);

        System.out.println("\nBooking History:");
        history.showHistory();

        sc.close();
    }
}