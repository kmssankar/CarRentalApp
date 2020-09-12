package com.cts.fse.car.rental.dto;

import java.util.Date;

public class MyBookingsDTO {

	int Id;
	int inventoryId;
	Date bookingDate;
	Date bookingFrom;
	Date bookingTo;
	int bookedUserId;
	double bookedAdvance;
	String model;
	String brand;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public int getInventoryId() {
		return inventoryId;
	}
	public void setInventoryId(int inventoryId) {
		this.inventoryId = inventoryId;
	}
	public Date getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
	public Date getBookingFrom() {
		return bookingFrom;
	}
	public void setBookingFrom(Date bookingFrom) {
		this.bookingFrom = bookingFrom;
	}
	public Date getBookingTo() {
		return bookingTo;
	}
	public void setBookingTo(Date bookingTo) {
		this.bookingTo = bookingTo;
	}
	public int getBookedUserId() {
		return bookedUserId;
	}
	public void setBookedUserId(int bookedUserId) {
		this.bookedUserId = bookedUserId;
	}
	public double getBookedAdvance() {
		return bookedAdvance;
	}
	public void setBookedAdvance(double bookedAdvance) {
		this.bookedAdvance = bookedAdvance;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
}
