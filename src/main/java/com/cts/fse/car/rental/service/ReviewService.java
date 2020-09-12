package com.cts.fse.car.rental.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.fse.car.rental.dto.UserCarReviewDTO;
import com.cts.fse.car.rental.entities.User;
import com.cts.fse.car.rental.exceptions.CarRentalException;
import com.cts.fse.car.rental.repository.ReviewSQLRepo;

@Service
public class ReviewService {

	@Autowired
	ReviewSQLRepo reviewSQLRepo;
	@Autowired
	AppUserInfoService appUserInfoService;

	public List<UserCarReviewDTO> getAllCarReviews() throws CarRentalException {
		List<UserCarReviewDTO> userCarReviewDTOs = new ArrayList<>();
		try {

			if (appUserInfoService.isUserHasRole("ROLE_ADMIN")) {
				userCarReviewDTOs = reviewSQLRepo.getUserCarReviewsAdmin();
			} else {
				User user = appUserInfoService.getLoggedInUserObj();
				userCarReviewDTOs = reviewSQLRepo.getUserCarReviews(user.getId());
			}
		} catch (Exception e) {
			throw new CarRentalException("Exception while getting reviews " + e);
		}
		return userCarReviewDTOs;
	}

}
