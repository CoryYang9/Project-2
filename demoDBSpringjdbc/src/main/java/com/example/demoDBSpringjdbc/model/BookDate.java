package com.example.demoDBSpringjdbc.model;

import java.sql.Date;
import java.time.LocalDateTime;

public class BookDate {
	
	private int ID;
	private String LastName;
	private String FirstName;
	private Date BookingDate;
	
	public int getID() {
		return ID;
	}
	public void setID(int id) {
		ID = id;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public Date getBookingDate() {
		return BookingDate;
	}
	public void setBookingDate(Date bookingDate) {
		BookingDate = bookingDate;
	}

	
}
