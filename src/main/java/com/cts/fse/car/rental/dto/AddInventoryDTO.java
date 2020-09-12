package com.cts.fse.car.rental.dto;

public class AddInventoryDTO {
	
	int id;
	String brand;
	String model;
	String fuel;
	double avgMileage;
	String regNo;
	String carType;
	int maxPassangers;
	double rentPerDay;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getFuel() {
		return fuel;
	}
	public void setFuel(String fuel) {
		this.fuel = fuel;
	}
	public double getAvgMileage() {
		return avgMileage;
	}
	public void setAvgMileage(double avgMileage) {
		this.avgMileage = avgMileage;
	}
	public String getRegNo() {
		return regNo;
	}
	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}
	public String getCarType() {
		return carType;
	}
	public void setCarType(String carType) {
		this.carType = carType;
	}
	public int getMaxPassangers() {
		return maxPassangers;
	}
	public void setMaxPassangers(int maxPassangers) {
		this.maxPassangers = maxPassangers;
	}
	public double getRentPerDay() {
		return rentPerDay;
	}
	public void setRentPerDay(double rentPerDay) {
		this.rentPerDay = rentPerDay;
	}
	@Override
	public String toString() {
		return "AddInventoryDTO [id=" + id + ", brand=" + brand + ", model=" + model + ", fuel=" + fuel
				+ ", avgMileage=" + avgMileage + ", regNo=" + regNo + ", carType=" + carType + ", maxPassangers="
				+ maxPassangers + ", rentPerDay=" + rentPerDay + "]";
	}
	
	
}
