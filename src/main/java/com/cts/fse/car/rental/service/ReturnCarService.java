package com.cts.fse.car.rental.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.cts.fse.car.rental.dto.FunctionResponseDTO;
import com.cts.fse.car.rental.dto.ReturnCarReviewDTO;
import com.cts.fse.car.rental.entities.CarBooking;
import com.cts.fse.car.rental.entities.CarReviews;
import com.cts.fse.car.rental.exceptions.CarRentalException;
import com.cts.fse.car.rental.repository.CarBookingRepository;
import com.cts.fse.car.rental.repository.CarReviewRepository;

@Service
public class ReturnCarService implements IReturnCarService {
	@Autowired
	CarReviewRepository carReviewRepository;
	@Autowired
	CarBookingRepository carBookingRepository;

	@Override
	public FunctionResponseDTO returnCarWithFeedback(ReturnCarReviewDTO returnCarReviewDTO) throws CarRentalException {
		try {
			CarBooking carbooking = carBookingRepository.findById(returnCarReviewDTO.getBookingId()).orElse(null);
			carbooking.setCarReturned(true);
			carBookingRepository.save(carbooking);
			CarReviews carReviews = new CarReviews();
			carReviews.setBookingId(returnCarReviewDTO.getBookingId());
			carReviews.setRating(returnCarReviewDTO.getRating());
			carReviews.setComment(returnCarReviewDTO.getComments());
			carReviewRepository.save(carReviews); 

		} catch (DataAccessException de) {
			new CarRentalException("Data Access Exception while returning the vehicle ", de);
		} catch (Exception e) {
			new CarRentalException("Exception while returning the vehicle ", e);
		}
		return new FunctionResponseDTO("Successfully car returned with reviews ! ", true);
	}
}
