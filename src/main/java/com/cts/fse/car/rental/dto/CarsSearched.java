package com.cts.fse.car.rental.dto;

public class CarsSearched {
	
	String brand;
	String model;
	String fuel;
	double avgMileage;
	double rentPerDay;
	String bookingLink;
	
	public CarsSearched(String brand, String model, double avgMileage, double rentPerDay, String bookingLink,String fuel) {
		super();
		this.brand = brand;
		this.model = model;
		this.avgMileage = avgMileage;
		this.rentPerDay = rentPerDay;
		this.bookingLink = bookingLink;
		this.fuel = fuel;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public double getAvgMileage() {
		return avgMileage;
	}
	public void setAvgMileage(double avgMileage) {
		this.avgMileage = avgMileage;
	}
	public double getRentPerDay() {
		return rentPerDay;
	}
	public void setRentPerDay(double rentPerDay) {
		this.rentPerDay = rentPerDay;
	}
	public String getBookingLink() {
		return bookingLink;
	}
	public void setBookingLink(String bookingLink) {
		this.bookingLink = bookingLink;
	}
	public String getFuel() {
		return fuel;
	}
	public void setFuel(String fuel) {
		this.fuel = fuel;
	}
	
	

}
