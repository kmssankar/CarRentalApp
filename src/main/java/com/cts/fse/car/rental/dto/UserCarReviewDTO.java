package com.cts.fse.car.rental.dto;

import java.util.List;

public class UserCarReviewDTO {
	
	int avgRating;
	int noOfRatings;
	String model;
	String regNo;
	String brand;
	
	List<String> comments;

	public int getAvgRating() {
		return avgRating;
	}

	public void setAvgRating(int avgRating) {
		this.avgRating = avgRating;
	}

	public int getNoOfRatings() {
		return noOfRatings;
	}

	public void setNoOfRatings(int noOfRatings) {
		this.noOfRatings = noOfRatings;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public List<String> getComments() {
		return comments;
	}

	public void setComments(List<String> comments) {
		this.comments = comments;
	}

}
