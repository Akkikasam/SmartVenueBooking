package com.bookingapp.model;

	public class ToLet extends Venue {

	    public ToLet(int id, String name, String location, double monthlyRent, int capacity) {
	        super(id, name, location, monthlyRent, capacity);
	    }

	    @Override
	    public double calculateFinalPrice() {
	        return price;
	    }

	    @Override
	    public String toString() {
	        return String.format("%s | To-Let | %s | \u20B9%.0f/month | Capacity: %d",
	                name, location, price, capacity);
	    }
	}

