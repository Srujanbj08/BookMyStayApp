package com.bookmystayapp;

public class FailedQueueTest {

    public static void main(String[] args) {

        BookingQueueService queue = new BookingQueueService();

        Reservation r1 = new Reservation("R1","Single");
        Reservation r2 = new Reservation("R2","Double");

        queue.addBookingRequest(r1);
        queue.addBookingRequest(r2);

        Reservation first = queue.getNextRequest();

        // Intentionally wrong expectation
        if(first.getReservationId().equals("R2")) {
            System.out.println("TEST PASSED");
        }
        else {
            System.out.println("TEST FAILED");
        }
    }
}