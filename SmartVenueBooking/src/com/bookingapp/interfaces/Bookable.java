package com.bookingapp.interfaces;

import com.bookingapp.model.User;

public interface Bookable {
	    boolean book(String date, User user);
	    boolean cancelBooking(String date, User user);
	}


