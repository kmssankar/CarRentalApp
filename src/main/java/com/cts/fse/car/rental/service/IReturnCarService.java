package com.cts.fse.car.rental.service;
import com.cts.fse.car.rental.dto.FunctionResponseDTO;
import com.cts.fse.car.rental.dto.ReturnCarReviewDTO;
import com.cts.fse.car.rental.exceptions.CarRentalException;

public interface IReturnCarService {
	
	public FunctionResponseDTO returnCarWithFeedback(ReturnCarReviewDTO returnCarReviewDTO) throws CarRentalException;

}
