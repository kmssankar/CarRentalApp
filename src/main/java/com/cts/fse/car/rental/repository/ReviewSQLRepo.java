package com.cts.fse.car.rental.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cts.fse.car.rental.constants.CarRentalConstaants;
import com.cts.fse.car.rental.dto.UserCarReviewDTO;
import com.cts.fse.car.rental.exceptions.CarRentalException;

@Repository
public class ReviewSQLRepo {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<UserCarReviewDTO> getUserCarReviews (int userId) throws CarRentalException{
		List<UserCarReviewDTO> carReviews = new ArrayList<>();
		try {
			carReviews = jdbcTemplate.query(CarRentalConstaants.REVIEW_QUERY, new Object[] {userId }, (rs, rowNum) -> {
			UserCarReviewDTO ur = new UserCarReviewDTO();
		    ur.setAvgRating(rs.getInt("avgRating"));
		    ur.setNoOfRatings(rs.getInt("count"));
		    ur.setModel(rs.getString("model"));
		    ur.setBrand(rs.getString("brand"));
		    ur.setRegNo(rs.getString("regno"));
		    return ur;
		});
		}
		catch (DataAccessException e) {
			throw new CarRentalException("Date Exception during fetching reviews",e); 
		}catch (Exception e) {
			throw new CarRentalException("Exception during fetching reviews",e); 
		}
		return carReviews;
	}
	
	public List<UserCarReviewDTO> getUserCarReviewsAdmin () throws CarRentalException{
		List<UserCarReviewDTO> carReviews = new ArrayList<>();
		try {
			carReviews = jdbcTemplate.query(CarRentalConstaants.REVIEW_QUERY_ADMIN, (rs, rowNum) -> {
			UserCarReviewDTO ur = new UserCarReviewDTO();
		    ur.setAvgRating(rs.getInt("avgRating"));
		    ur.setNoOfRatings(rs.getInt("count"));
		    ur.setModel(rs.getString("model"));
		    ur.setBrand(rs.getString("brand"));
		    ur.setRegNo(rs.getString("regno"));
		    return ur;
		});
		}
		catch (DataAccessException e) {
			throw new CarRentalException("Date Exception during fetching reviews",e); 
		}catch (Exception e) {
			throw new CarRentalException("Exception during fetching reviews",e); 
		}
		return carReviews;
	}
	
}
