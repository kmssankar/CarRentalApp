package com.cts.fse.car.rental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cts.fse.car.rental.constants.CarRentalConstaants;
import com.cts.fse.car.rental.constants.CarRentalUtils;
import com.cts.fse.car.rental.dto.BookingRequestDTO;
import com.cts.fse.car.rental.dto.FunctionResponseDTO;
import com.cts.fse.car.rental.dto.ReturnCarReviewDTO;
import com.cts.fse.car.rental.dto.UserBookingsDTO;
import com.cts.fse.car.rental.exceptions.CarRentalException;
import com.cts.fse.car.rental.service.BookingService;
import com.cts.fse.car.rental.service.ReturnCarService;

@Controller
public class BookCarController {
	@Autowired
	BookingService bookingService;

	@Autowired
	ReturnCarService returnCarService;

	@GetMapping("/bookacar")
	public String getbookCar(Model model) {

		model.addAttribute("bookingRequestDTO", new BookingRequestDTO());
		model.addAttribute("resultfound", false);
		model.addAttribute("noresult", false);
		model.addAttribute("showspace",true);
		return CarRentalConstaants.BOOK_CAR_PAGE;
	}

	@PostMapping("/bookacar")
	public String postbookCar(Model model, @ModelAttribute BookingRequestDTO bookingRequestDTO)
			throws CarRentalException {
		String respMsg = "";
		bookingService.searchcars(bookingRequestDTO);
		model.addAttribute("bookingRequestDTO", bookingRequestDTO);
		FunctionResponseDTO  func = CarRentalUtils.validateSearchInp(bookingRequestDTO);
		if (func.isStatus()) {
			if (bookingRequestDTO.getSearchResult() != null) {
				model.addAttribute("resultfound", bookingRequestDTO.getSearchResult().size() > 0);
				model.addAttribute("noresult", bookingRequestDTO.getSearchResult().size() == 0);
				model.addAttribute("showspace",true);
			} else {
				model.addAttribute("noresult", false);
				model.addAttribute("showspace",false);
			}
		} else {
			System.out.println("Resp message : "+ respMsg);
			model.addAttribute("errorInp",true);
			model.addAttribute("errormsg",func.getMessage());
			model.addAttribute("showspace",true);
		}
		
		return CarRentalConstaants.BOOK_CAR_PAGE;
	}

	@GetMapping("/confirmBooking")
	public String getConfirmBooking(Model model, @RequestParam int id, @RequestParam String fromdt,
			@RequestParam String toDate) throws CarRentalException {
		FunctionResponseDTO response = bookingService.bookcar(id, fromdt, toDate);
		if (response.isStatus()) {
			model.addAttribute("bookingRespHeading", "Booking Successfully");
			model.addAttribute("bookingResponse", response.getMessage());
		} else {
			model.addAttribute("bookingRespHeading", "Booking failed");
			model.addAttribute("bookingResponse", response.getMessage());
		}
		return CarRentalConstaants.CONFIRM_BOOKING_PAGE;
	}

	@GetMapping("/mybookings")
	public String getMybooking(Model model) throws CarRentalException {
		UserBookingsDTO userBookingsDTO = new UserBookingsDTO();
		bookingService.getMyBookings(userBookingsDTO);
		model.addAttribute("bookings", userBookingsDTO.getBookings());
		model.addAttribute("returnCarReviewDTO", new ReturnCarReviewDTO());
		if (userBookingsDTO.getBookings().size() < 1) {
			model.addAttribute("noresult", true);
		} else {
			model.addAttribute("noresult", false);
		}
		return CarRentalConstaants.MY_BOOKING_PAGE;
	}

	@PostMapping("/returncar")
	public String postReturnMybooking(Model model, @ModelAttribute ReturnCarReviewDTO returnCarReviewDTO)
			throws CarRentalException {
		FunctionResponseDTO functionResponseDTO = bookingService.returnmycar(returnCarReviewDTO);
		if (functionResponseDTO.isStatus()) {
			model.addAttribute("returnRespHeading", "Return Success !");
			model.addAttribute("returnResponse", functionResponseDTO.getMessage());
		} else {
			model.addAttribute("returnRespHeading", "Return Success !");
			model.addAttribute("returnResponse", functionResponseDTO.getMessage());
		}
		return CarRentalConstaants.MY_RETURN_PAGE;
	}

}
