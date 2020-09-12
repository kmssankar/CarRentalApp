package com.cts.fse.car.rental.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cts.fse.car.rental.entities.Role;

public interface  RoleRepository extends JpaRepository<Role, Integer> {

	@Query("Select r from Role r where r.name = ?1")
	public Optional<Role> getRolebyName(String Name);
	
	
}
