package com.cts.fse.car.rental.controller;

public class ManageInvDTO {
	
	int invId;
	String brand;
	String model;
	int maxPassanger;
	String dailyRent;
	String activeflg;
	public int getInvId() {
		return invId;
	}
	public void setInvId(int invId) {
		this.invId = invId;
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
	public int getMaxPassanger() {
		return maxPassanger;
	}
	public void setMaxPassanger(int maxPassanger) {
		this.maxPassanger = maxPassanger;
	}
	
	public String getDailyRent() {
		return dailyRent;
	}
	public void setDailyRent(String dailyRent) {
		this.dailyRent = dailyRent;
	}
	public String getActiveflg() {
		return activeflg;
	}
	public void setActiveflg(String activeflg) {
		this.activeflg = activeflg;
	}
	@Override
	public String toString() {
		return "ManageInvDTO [invId=" + invId + ", brand=" + brand + ", model=" + model + ", maxPassanger="
				+ maxPassanger + ", dailyRent=" + dailyRent + ", activeflg=" + activeflg + "]";
	}
	
	
	

}
