package com.cts.fse.car.rental.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.fse.car.rental.entities.CarReviews;

public interface CarReviewRepository extends JpaRepository<CarReviews, Integer> {
	

}
