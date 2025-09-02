package com.bookingapp.main;

import com.bookingapp.factory.VenueFactory;
import com.bookingapp.manager.BookingManager;
import com.bookingapp.model.*;

public class Application {

    private static Venue[] seedVenues() {
        Venue[] venues = new Venue[5];
        venues[0] = VenueFactory.createVenue("FunctionHall", 1, "Grand Palace", "Hyderabad", 50000, 500);
        venues[1] = VenueFactory.createVenue("Workspace", 2, "CoWork Hub", "Bangalore", 500, 20);
        venues[2] = VenueFactory.createVenue("ToLet", 3, "TechPark Office", "Chennai", 100000, 50);
        venues[3] = VenueFactory.createVenue("Workspace", 4, "StartUp Bay", "Hyderabad", 400, 15);
        venues[4] = VenueFactory.createVenue("FunctionHall", 5, "Royal Court", "Bangalore", 60000, 600);
        return venues;
    }

    public static void main(String[] args) {
        Venue[] venues = seedVenues();
        User alice = new User(101, "Alice", "alice@example.com");
        User[] users = new User[] { alice };

        // 🔹 Print only Hyderabad venues
        System.out.println("[INFO] Venues in Hyderabad:");
        Venue[] hyd = alice.search(venues, "Hyderabad");
        for (int i = 0; i < hyd.length; i++) {
            System.out.printf("   %d. %s%n", i + 1, hyd[i]);
        }

        BookingManager bm = BookingManager.getInstance();
        Venue grandPalace = venues[0];
        String date = "15-09-2025";

        // 🔹 Book Grand Palace
        boolean booked = grandPalace.book(date, alice);
        if (booked) {
            double finalPrice;
            if (grandPalace instanceof FunctionHall) {
                finalPrice = ((FunctionHall) grandPalace).calculateFinalPrice(date);
            } else {
                finalPrice = grandPalace.calculateFinalPrice();
            }
            System.out.println("\n[BOOKING SUCCESS]");
            System.out.println("   Booking ID: BK101"); // fixed ID
            System.out.println("   Venue: " + grandPalace.getName());
            System.out.println("   Date: " + date);
            System.out.println("   Final Price: ₹" + String.format("%,d", (int) finalPrice));
        } else {
            System.out.println("\n[ERROR] AlreadyBookedException: " + grandPalace.getName() + " is already booked for " + date + ".");
        }

        // 🔹 Try booking again
        boolean bookedAgain = grandPalace.book(date, alice);
        if (!bookedAgain) {
            System.out.println("\n[ERROR] AlreadyBookedException: " + grandPalace.getName() + " is already booked for " + date + ".");
        }

        // 🔹 Cancel booking
        boolean cancelled = grandPalace.cancelBooking(date, alice);
        if (cancelled) {
            System.out.println("\n[CANCEL SUCCESS] Booking BK101 cancelled successfully.");
        }

        // (Optional) Save + Load bookings
        String bookingsPath = "bookings.txt";
        try {
            bm.saveToFile(bookingsPath);
            bm.loadFromFile(bookingsPath, venues, users);
        } catch (Exception e) {
            System.out.println("[WARN] File operations failed: " + e.getMessage());
        }
    }
}
