package com.cts.fse.car.rental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cts.fse.car.rental.constants.CarRentalConstaants;
import com.cts.fse.car.rental.dto.FunctionResponseDTO;
import com.cts.fse.car.rental.dto.ManageRoleDTO;
import com.cts.fse.car.rental.exceptions.CarRentalException;
import com.cts.fse.car.rental.service.ManageUserService;

@Controller
public class ManageUserController {
  @Autowired 
  ManageUserService manageUserService;
	
	@GetMapping("/manageroles")
	public String getAllusers(Model model) throws CarRentalException{
		model.addAttribute("userList", manageUserService.getAllusers());
		model.addAttribute("manageRoleDTO",new ManageRoleDTO());
		return CarRentalConstaants.MANAGE_ROLES_PAGE;
	}
	
	@PostMapping("/manageroles")
	public String Updateuser(Model model,@ModelAttribute ManageRoleDTO manageRoleDTO) throws CarRentalException{
		System.out.println(manageRoleDTO);
		FunctionResponseDTO functionResponseDTO =  manageUserService.manageaUser(manageRoleDTO);
		if(functionResponseDTO.isStatus()) {
			model.addAttribute("bookingRespHeading", "Role managed Successfully");
			model.addAttribute("bookingResponse",functionResponseDTO.getMessage() );
		}
		else {
			model.addAttribute("bookingRespHeading", "Role management request failed !");
			model.addAttribute("bookingResponse",functionResponseDTO.getMessage() );
		}
		return CarRentalConstaants.MANAGE_ROLES_RESP_PAGE;
	}
	
	
}
