package com.cts.fse.car.rental.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.cts.fse.car.rental.entities.Role;
import com.cts.fse.car.rental.entities.User;
import com.cts.fse.car.rental.repository.UserRepository;
import com.cts.fse.car.rental.security.AppUserDetails;



@Service
public class AppUserInfoService {
	
	@Autowired
	UserRepository userRepository;
	

	public String getLoggedInUser() {
		String username;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof AppUserDetails) {
			 username = ((AppUserDetails) principal).getUsername();
		} else {
			 username = principal.toString();
		}
		return username;
	}
	
	public User getLoggedInUserObj() {
		String username;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof AppUserDetails) {
			 username = ((AppUserDetails) principal).getUsername();
		} else {
			 username = principal.toString();
		}
		User user = userRepository.getUserByUserName(username).get();
		return user;
	}
	
	public boolean isUserHasRole(String roleInp) {
		String username;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof AppUserDetails) {
			 username = ((AppUserDetails) principal).getUsername();
		} else {
			 username = principal.toString();
		}
		User user = userRepository.getUserByUserName(username).get();
		Set<Role> roles = user.getRoles();
		for(Role role : roles) {
			if (role.getName().equalsIgnoreCase(roleInp)) return true;
		}
		return false;
	}
}
