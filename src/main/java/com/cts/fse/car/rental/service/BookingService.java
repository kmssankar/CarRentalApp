package com.cts.fse.car.rental.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.cts.fse.car.rental.constants.CarRentalConstaants;
import com.cts.fse.car.rental.dto.BookingRequestDTO;
import com.cts.fse.car.rental.dto.CarsSearched;
import com.cts.fse.car.rental.dto.FunctionResponseDTO;
import com.cts.fse.car.rental.dto.ReturnCarReviewDTO;
import com.cts.fse.car.rental.dto.UserBookingsDTO;
import com.cts.fse.car.rental.entities.CarBooking;
import com.cts.fse.car.rental.entities.CarReviews;
import com.cts.fse.car.rental.entities.Inventory;
import com.cts.fse.car.rental.entities.User;
import com.cts.fse.car.rental.exceptions.CarRentalException;
import com.cts.fse.car.rental.repository.CarBookingRepository;
import com.cts.fse.car.rental.repository.CarReviewRepository;
import com.cts.fse.car.rental.repository.InventoryRepository;

@Service
public class BookingService implements IBookingService {

	@Autowired
	InventoryRepository inventoryRepository;
	@Autowired
	AppUserInfoService appUserInfoService;
	@Autowired
	CarBookingRepository carBookingRepository;
	
	@Autowired 
	CarReviewRepository carReviewRepository;

	@Override
	public FunctionResponseDTO searchcars(BookingRequestDTO bookingRequestDTO) throws CarRentalException {
		try {
			List<Inventory> searchRes = inventoryRepository.findAvailablebasedOndate(
					new SimpleDateFormat("MM/dd/yyyy").parse(bookingRequestDTO.getFromDate()),
					new SimpleDateFormat("MM/dd/yyyy").parse(bookingRequestDTO.getToDate()),
					bookingRequestDTO.getCarType(), bookingRequestDTO.getNoOfPassaners());

			List<CarsSearched> carOutList = searchRes.stream()
					.map(n -> new CarsSearched(n.getBrand(), n.getModel(), n.getAvgMileage(), n.getRentPerDay(),
							CarRentalConstaants.BOOK_GET_URL.replaceAll(":id", n.getId() + "")
									.replaceAll(":num", bookingRequestDTO.getNoOfPassaners() + "")
									.replaceAll(":fromdt", bookingRequestDTO.getFromDate())
									.replaceAll(":todt", bookingRequestDTO.getToDate()),n.getFuel()))
					.collect(Collectors.toList());
			bookingRequestDTO.setSearchResult(carOutList);
		} catch (ParseException e) {
			throw new CarRentalException("Exception while parsing date ", e);
		}
		return new FunctionResponseDTO("search car is success", true);
	}

	@Override
	public FunctionResponseDTO bookcar(int inventoryId, String fromDate, String toDate) throws CarRentalException {
		
		try {
			User user = appUserInfoService.getLoggedInUserObj();
			Inventory inv = inventoryRepository.validateAvailablebasedOndate(
					new SimpleDateFormat("MM/dd/yyyy").parse(fromDate),
					new SimpleDateFormat("MM/dd/yyyy").parse(toDate), inventoryId);
			if (inv != null) {
				CarBooking carBooking = new CarBooking();
				carBooking.setBookedUserId(user.getId());
				carBooking.setBookingFrom(new SimpleDateFormat("MM/dd/yyyy").parse(fromDate));
				carBooking.setBookingTo(new SimpleDateFormat("MM/dd/yyyy").parse(toDate));
				carBooking.setInventoryId(inventoryId);
				carBooking.setBookingDate(new Date());
				long difference_In_Time = carBooking.getBookingTo().getTime() - carBooking.getBookingFrom().getTime();
				int noOfDays = (int) (TimeUnit.MILLISECONDS.toDays(difference_In_Time) + 1);
				carBooking.setBookedAdvance(noOfDays * inv.getRentPerDay());
				CarBooking carBookingsaved = carBookingRepository.save(carBooking);
				return new FunctionResponseDTO("Successfully booked the car : Booking id -> " + carBookingsaved.getId(),
						true);
			} else {
				return new FunctionResponseDTO("Please book another car this car already got booked ", false);
			}

		} catch (ParseException e) {
			throw new CarRentalException("Exception while parsing date ", e);
		} catch (DataAccessException e) {
			throw new CarRentalException("Exception while confirmig booking ", e);
		}
	}
	
	
	@Override
	public FunctionResponseDTO getMyBookings(UserBookingsDTO userBookingsDTO) throws CarRentalException {
		try {
		User user = appUserInfoService.getLoggedInUserObj();		
		List<CarBooking> bookingList = carBookingRepository.findbookingbyUserId(user.getId());
		userBookingsDTO.setUserName(user.getFirstName() + " " + user.getLastName());
		userBookingsDTO.setUserId(user.getId());
		userBookingsDTO.setBookings(bookingList);
		return new FunctionResponseDTO("Successfully retrived all the bookings of user  -> " + user.getId(),true);
		}
		catch(DataAccessException de) {
			throw new CarRentalException("Exception while parsing date ", de);
		}catch(Exception e) {
			throw new CarRentalException("Exception while getting all booking Infos", e);
		}
		
	}
	
	@Override
	public FunctionResponseDTO returnmycar(ReturnCarReviewDTO  returnCarReviewDTO) throws CarRentalException {
		System.out.println(" Return car Input"+returnCarReviewDTO);
		try {
			CarBooking carBooking = carBookingRepository.findById(returnCarReviewDTO.getBookingId()).orElse(null);
			CarReviews carreview = new CarReviews();
			carreview.setBookingId(returnCarReviewDTO.getBookingId());
			carreview.setComment(returnCarReviewDTO.getComments());
			carreview.setRating(returnCarReviewDTO.getRating());			
			carReviewRepository.save(carreview);
			carBooking.setCarReturned(true);
			carBookingRepository.save(carBooking);
		}
		catch(DataAccessException de) {
			throw new CarRentalException("Exception while persisting the return ! ", de);
		}catch(Exception e) {
			throw new CarRentalException("Exception while Returning the car ", e);
		}
		return new FunctionResponseDTO("Successfully processed return request  -> " + returnCarReviewDTO.getBookingId(),true);
	}
	
	
}