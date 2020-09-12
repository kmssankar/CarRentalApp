package com.cts.fse.car.rental.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cts.fse.car.rental.entities.User;


public interface UserRepository  extends JpaRepository<User, Integer>{

	@Query("Select u from User u where u.userName = ?1  and u.active='Y'")
	public Optional<User> getUserByUserName(String username);
	
}
