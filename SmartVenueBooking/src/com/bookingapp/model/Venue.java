package com.bookingapp.model;

	import java.util.Objects;
	import com.bookingapp.interfaces.Bookable;
	import com.bookingapp.manager.BookingManager;

	public abstract class Venue implements Bookable {
	    protected int id;
	    protected String name;
	    protected String location;
	    protected double price;
	    protected int capacity;

	    public Venue(int id, String name, String location, double price, int capacity) {
	        this.id = id;
	        this.name = name;
	        this.location = location;
	        this.price = price;
	        this.capacity = capacity;
	    }

	    public int getId() { return id; }
	    public String getName() { return name; }
	    public String getLocation() { return location; }
	    public double getPrice() { return price; }
	    public int getCapacity() { return capacity; }

	    public void setPrice(double price) { this.price = price; }

	    public abstract double calculateFinalPrice();

	    @Override
	    public boolean book(String date, com.bookingapp.model.User user) {
	        return BookingManager.getInstance().addBooking(this, user, date);
	    }

	    @Override
	    public boolean cancelBooking(String date, com.bookingapp.model.User user) {
	        return BookingManager.getInstance().cancelBooking(this, user, date);
	    }

	    @Override
	    public String toString() {
	        return String.format("%s | %s | %.2f | Capacity: %d", name, location, price, capacity);
	    }

	    @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;
	        Venue venue = (Venue) o;
	        return id == venue.id;
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(id);
	    }
	}


