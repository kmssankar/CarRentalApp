package com.cts.fse.car.rental.service;

import com.cts.fse.car.rental.dto.BookingRequestDTO;
import com.cts.fse.car.rental.dto.FunctionResponseDTO;
import com.cts.fse.car.rental.dto.ReturnCarReviewDTO;
import com.cts.fse.car.rental.dto.UserBookingsDTO;
import com.cts.fse.car.rental.exceptions.CarRentalException;

public interface IBookingService {
	
	
	public FunctionResponseDTO searchcars(BookingRequestDTO bookingRequestDTO) throws CarRentalException;
	
	public FunctionResponseDTO bookcar(int inventoryId, String fromDate, String toDate)  throws CarRentalException;
	
	public FunctionResponseDTO getMyBookings(UserBookingsDTO userBookingsDTO) throws CarRentalException;

	public FunctionResponseDTO returnmycar(ReturnCarReviewDTO  returnCarReviewDTO) throws CarRentalException;
}
