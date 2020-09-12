package com.cts.fse.car.rental.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cts.fse.car.rental.entities.CarBooking;

public interface CarBookingRepository extends JpaRepository<CarBooking, Integer>{
	
	
	@Query("Select b from CarBooking b where b.bookedUserId = :usrid and b.carReturned = false")
	public List<CarBooking> findbookingbyUserId(int usrid);

}
