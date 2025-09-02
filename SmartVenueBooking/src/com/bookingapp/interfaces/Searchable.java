package com.bookingapp.interfaces;

import com.bookingapp.model.Venue;

public interface Searchable {
	    Venue[] search(Venue[] venues, String keyword);
	}


