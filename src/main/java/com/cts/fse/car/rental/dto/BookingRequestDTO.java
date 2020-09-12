package com.cts.fse.car.rental.dto;

import java.util.List;

public class BookingRequestDTO {

	String fromDate;
	String toDate;
	int noOfPassaners;
	String carType;
	
	List<CarsSearched> searchResult;

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public int getNoOfPassaners() {
		return noOfPassaners;
	}

	public void setNoOfPassaners(int noOfPassaners) {
		this.noOfPassaners = noOfPassaners;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public List<CarsSearched> getSearchResult() {
		return searchResult;
	}

	public void setSearchResult(List<CarsSearched> searchResult) {
		this.searchResult = searchResult;
	}

	
}
