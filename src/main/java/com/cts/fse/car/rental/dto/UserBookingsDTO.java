package com.cts.fse.car.rental.dto;

import java.util.List;

import com.cts.fse.car.rental.entities.CarBooking;

public class UserBookingsDTO {
	
	int userId;
	String userName;	
	List<CarBooking> bookings;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public List<CarBooking> getBookings() {
		return bookings;
	}
	public void setBookings(List<CarBooking> bookings) {
		this.bookings = bookings;
	}
	
	

}
