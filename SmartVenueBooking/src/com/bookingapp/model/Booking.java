package com.bookingapp.model;

	public class Booking {
	    private String bookingId;
	    private Venue venue;
	    private User user;
	    private String date; // dd-MM-yyyy

	    public Booking(String bookingId, Venue venue, User user, String date) {
	        this.bookingId = bookingId;
	        this.venue = venue;
	        this.user = user;
	        this.date = date;
	    }

	    public String getBookingId() { return bookingId; }
	    public Venue getVenue() { return venue; }
	    public User getUser() { return user; }
	    public String getDate() { return date; }

	    @Override
	    public String toString() {
	        return String.format("BookingID: %s | Venue: %s | User: %s | Date: %s",
	                bookingId, venue.getName(), user.getName(), date);
	    }

	    // CSV: bookingId,venueId,userId,date
	    public String toCSV() {
	        return bookingId + "," + venue.getId() + "," + user.getId() + "," + date;
	    }

	    public static Booking fromCSV(String csv, Venue[] venues, User[] users) {
	        String[] parts = csv.split(",");
	        String id = parts[0];
	        int venueId = Integer.parseInt(parts[1]);
	        int userId = Integer.parseInt(parts[2]);
	        String date = parts[3];

	        Venue v = null;
	        for (Venue ve : venues) {
	            if (ve != null && ve.getId() == venueId) { v = ve; break; }
	        }
	        User u = null;
	        for (User us : users) {
	            if (us != null && us.getId() == userId) { u = us; break; }
	        }
	        if (v == null || u == null) return null;
	        return new Booking(id, v, u, date);
	    }
	}

