package com.bookingapp.model;

	public class Workspace extends Venue {

	    public Workspace(int id, String name, String location, double pricePerHour, int capacity) {
	        super(id, name, location, pricePerHour, capacity);
	    }

	    // Per-hour pricing (base: 1 hour)
	    @Override
	    public double calculateFinalPrice() {
	        return price;
	    }

	    public double calculateFinalPrice(int hours) {
	        if (hours <= 0) hours = 1;
	        return price * hours;
	    }

	    @Override
	    public String toString() {
	        return String.format("%s | Workspace | %s | \u20B9%.0f/hour | Capacity: %d",
	                name, location, price, capacity);
	    }
	}


