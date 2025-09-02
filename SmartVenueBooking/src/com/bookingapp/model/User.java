package com.bookingapp.model;

	import com.bookingapp.interfaces.Searchable;

	public class User implements Searchable {
	    private int id;
	    private String name;
	    private String email;

	    public User(int id, String name, String email) {
	        this.id = id;
	        this.name = name;
	        this.email = email;
	    }

	    public int getId() { return id; }
	    public String getName() { return name; }
	    public String getEmail() { return email; }

	    @Override
	    public Venue[] search(Venue[] venues, String keyword) {
	        if (keyword == null) keyword = "";
	        keyword = keyword.toLowerCase();
	        int count = 0;
	        for (Venue v : venues) {
	            if (v == null) continue;
	            String type = v.getClass().getSimpleName().toLowerCase();
	            if (v.getName().toLowerCase().contains(keyword) ||
	                v.getLocation().toLowerCase().contains(keyword) ||
	                type.contains(keyword)) {
	                count++;
	            }
	        }
	        Venue[] results = new Venue[count];
	        int i = 0;
	        for (Venue v : venues) {
	            if (v == null) continue;
	            String type = v.getClass().getSimpleName().toLowerCase();
	            if (v.getName().toLowerCase().contains(keyword) ||
	                v.getLocation().toLowerCase().contains(keyword) ||
	                type.contains(keyword)) {
	                results[i++] = v;
	            }
	        }
	        return results;
	    }
	}


