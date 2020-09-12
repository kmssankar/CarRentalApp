package com.cts.fse.car.rental.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cts.fse.car.rental.constants.CarRentalConstaants;
import com.cts.fse.car.rental.dto.UserCarReviewDTO;
import com.cts.fse.car.rental.exceptions.CarRentalException;
import com.cts.fse.car.rental.service.ReviewService;

@Controller
public class ReviewController {
	@Autowired
	ReviewService reviewService;

	@GetMapping("/viewrevies")
	public String getAllReviews(Model model) throws CarRentalException {
		List<UserCarReviewDTO> reviewList = reviewService.getAllCarReviews();
		model.addAttribute("reviewList", reviewList); 
		if(reviewList.size() < 1) {
		model.addAttribute("noresult", true);
		}
		else {
			model.addAttribute("noresult", false);
		}
		return CarRentalConstaants.REVIEW_PAGE;
	}
	
}
