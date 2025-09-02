package com.bookingapp.manager;

	import java.io.*;
	import java.util.*;

	import com.bookingapp.model.Booking;
	import com.bookingapp.model.User;
	import com.bookingapp.model.Venue;

	public class BookingManager {
	    private static BookingManager instance;
	    private List<Booking> bookings = new ArrayList<>();

	    private BookingManager() {}

	    public static BookingManager getInstance() {
	        if (instance == null) {
	            synchronized (BookingManager.class) {
	                if (instance == null) instance = new BookingManager();
	            }
	        }
	        return instance;
	    }

	    public List<Booking> getBookings() { return bookings; }

	    private String nextBookingId() {
	        return "BK" + (100 + bookings.size() + 1);
	    }

	    public boolean isBooked(Venue venue, String date) {
	        for (Booking b : bookings) {
	            if (b.getVenue().getId() == venue.getId() && b.getDate().equals(date)) {
	                return true;
	            }
	        }
	        return false;
	    }

	    public boolean addBooking(Venue venue, User user, String date) {
	        if (isBooked(venue, date)) {
	            return false;
	        }
	        Booking b = new Booking(nextBookingId(), venue, user, date);
	        bookings.add(b);
	        return true;
	    }

	    public boolean cancelBooking(Venue venue, User user, String date) {
	        Iterator<Booking> it = bookings.iterator();
	        while (it.hasNext()) {
	            Booking b = it.next();
	            if (b.getVenue().getId() == venue.getId() && b.getDate().equals(date)) {
	                it.remove();
	                return true;
	            }
	        }
	        return false;
	    }

	    public void saveToFile(String path) throws IOException {
	        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
	            for (Booking b : bookings) {
	                bw.write(b.toCSV());
	                bw.newLine();
	            }
	        }
	    }

	    public void loadFromFile(String path, Venue[] venues, User[] users) throws IOException {
	        bookings.clear();
	        File f = new File(path);
	        if (!f.exists()) return;
	        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
	            String line;
	            while ((line = br.readLine()) != null) {
	                Booking b = Booking.fromCSV(line, venues, users);
	                if (b != null) bookings.add(b);
	            }
	        }
	    }
	}


