package com.example.demoDBSpringjdbc;

import java.time.LocalDateTime;

public class bookdate {
	
	private String LastName;
	private String FirstName;
	private LocalDateTime BookingDate;
	
	
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
	public LocalDateTime getBookingDate() {
		return BookingDate;
	}
	public void setBookingDate(LocalDateTime bookingDate) {
		BookingDate = bookingDate;
	}

	
	
}
