package com.bookingapp.factory;


	import com.bookingapp.model.*;

	public class VenueFactory {
	    public static Venue createVenue(String type, int id, String name, String location, double price, int capacity) {
	        switch (type.toLowerCase()) {
	            case "functionhall":
	            case "function hall":
	                return new FunctionHall(id, name, location, price, capacity);
	            case "workspace":
	                return new Workspace(id, name, location, price, capacity);
	            case "tolet":
	            case "to-let":
	            case "to_let":
	                return new ToLet(id, name, location, price, capacity);
	            default:
	                throw new IllegalArgumentException("Unknown venue type: " + type);
	        }
	    }
	}


