package com.cts.fse.car.rental.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.fse.car.rental.dto.FunctionResponseDTO;
import com.cts.fse.car.rental.dto.ManageRoleDTO;
import com.cts.fse.car.rental.entities.Role;
import com.cts.fse.car.rental.entities.User;
import com.cts.fse.car.rental.exceptions.CarRentalException;
import com.cts.fse.car.rental.repository.RoleRepository;
import com.cts.fse.car.rental.repository.UserRepository;

@Service
public class ManageUserService {

	@Autowired 
	UserRepository userRepository;
	@Autowired 
	RoleRepository roleRepository;
	
	public List<User> getAllusers(){
		List<User> userList = userRepository.findAll();
		return userList;
	}
	
	public FunctionResponseDTO manageaUser(ManageRoleDTO manageRoleDTO) throws CarRentalException{
		try {
			
		
		User user = userRepository.findById(manageRoleDTO.getManageId()).orElse(null);
		if(user !=null) {
			user.setActive(manageRoleDTO.getActiveFlag());
			user.getRoles().clear();
			for (Integer i:manageRoleDTO.getUserRoles()) {
				Role role = roleRepository.findById(i).get();
				user.getRoles().add(role);
			}
			userRepository.save(user);
			return new FunctionResponseDTO("User successFully Updated "+ manageRoleDTO.getManageId(), true);
		}
		else {
			return new FunctionResponseDTO("User Id Not Found for Update "+ manageRoleDTO.getManageId(), false);
		}
		
		}catch(Exception e) {
			throw new CarRentalException("Exception while performing manage roles "+ manageRoleDTO.getManageId(),e);
		}
	}
}
