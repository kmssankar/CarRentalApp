package com.cts.fse.car.rental.service;

import java.util.HashSet;
import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cts.fse.car.rental.constants.CarRentalConstaants;
import com.cts.fse.car.rental.dto.RegisterUser;
import com.cts.fse.car.rental.entities.Role;
import com.cts.fse.car.rental.entities.User;
import com.cts.fse.car.rental.repository.RoleRepository;
import com.cts.fse.car.rental.repository.UserRepository;


@Service
public class UserRegistrationService {
	@Autowired 
	UserRepository userRepository;
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	public boolean registerUsertoDB(RegisterUser regUser) {
		if(checkUserExistence(regUser.getUserName())){
		User user = new User();
		user.setUserName(regUser.getUserName());
		user.setFirstName(regUser.getFirstName());
		user.setLastName(regUser.getLastName());
		user.setEmailId(regUser.getEmail());
		user.setPhoneNo(regUser.getPhoneNo());
		user.setPassword(bCryptPasswordEncoder.encode(regUser.getPassword()));
		if(regUser.getEnableVedor() !=null) {
		user.setVendorRequest(regUser.getEnableVedor().equalsIgnoreCase("Y"));
		}
		else {
			user.setVendorRequest(false);
		}
		user.setActive(CarRentalConstaants.ACTIVE_FLAG_Y);
		Role role = roleRepository.getRolebyName("ROLE_USER").get();
		Set<Role> roleset = new HashSet<>();
		roleset.add(role);
		user.setRoles(roleset);
		userRepository.save(user);
		return true;
		}else {
			return false;
		}
	}
	
	public boolean checkUserExistence (String userName) {
		User validateUser = userRepository.getUserByUserName(userName).orElse(null);
		return (validateUser==null);
	}

}
