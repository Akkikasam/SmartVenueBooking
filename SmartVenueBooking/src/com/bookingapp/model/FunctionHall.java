package com.bookingapp.model;

	import java.time.LocalDate;
	import java.time.format.DateTimeFormatter;

	public class FunctionHall extends Venue {

	    public FunctionHall(int id, String name, String location, double pricePerDay, int capacity) {
	        super(id, name, location, pricePerDay, capacity);
	    }

	    // Base price (date-based overload below)
	    @Override
	    public double calculateFinalPrice() {
	        return price;
	    }

	    // Seasonal pricing: +10% for Oct–Dec
	    public double calculateFinalPrice(String date) {
	        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	        LocalDate d = LocalDate.parse(date, fmt);
	        int m = d.getMonthValue();
	        double finalPrice = price;
	        if (m >= 10 && m <= 12) {
	            finalPrice *= 1.10;
	        }
	        return finalPrice;
	    }

	    @Override
	    public String toString() {
	        return String.format("%s | Function Hall | %s | \u20B9%.0f/day | Capacity: %d",
	                name, location, price, capacity);
	    }
	}


