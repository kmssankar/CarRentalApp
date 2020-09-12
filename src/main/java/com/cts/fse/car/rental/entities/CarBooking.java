package com.cts.fse.car.rental.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class CarBooking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int Id;
	int inventoryId;
	@Temporal(TemporalType.TIMESTAMP)
	Date bookingDate;
	@Temporal(TemporalType.TIMESTAMP)
	Date bookingFrom;
	@Temporal(TemporalType.TIMESTAMP)
	Date bookingTo;
	int bookedUserId;
	double bookedAdvance;
	boolean carReturned;
	
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
	public boolean isCarReturned() {
		return carReturned;
	}
	public void setCarReturned(boolean carReturned) {
		this.carReturned = carReturned;
	}
}
