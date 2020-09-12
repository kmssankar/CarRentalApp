package com.cts.fse.car.rental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cts.fse.car.rental.constants.CarRentalConstaants;
import com.cts.fse.car.rental.dto.FunctionResponseDTO;
import com.cts.fse.car.rental.exceptions.CarRentalException;
import com.cts.fse.car.rental.service.ManageFleetService;

@Controller
public class ManageFleetController {

	@Autowired
	ManageFleetService managefleetservice;
	
	@GetMapping("/managefleet")
	public String getAllfleetCars(Model model) {
		model.addAttribute("inventoryList", managefleetservice.getFleetbyUser());
		return CarRentalConstaants.MANAGE_FLEET_PAGE;
	}
	
	@PostMapping("/managefleet")
	public String postManageCar(Model model,@ModelAttribute ManageInvDTO manageInvDTO) throws CarRentalException {
		System.out.println("Manage Inv DTO -> "+manageInvDTO);
		FunctionResponseDTO func = managefleetservice.updateFleetId(manageInvDTO);
		if(func.isStatus()) {
			model.addAttribute("bookingRespHeading", "Inventory managed Successfully");
			model.addAttribute("bookingResponse",func.getMessage() );
		}
		else {
			model.addAttribute("bookingRespHeading", "Inventory management request failed !");
			model.addAttribute("bookingResponse",func.getMessage() );
		}
		return CarRentalConstaants.MANAGE_FLEET_RESP_PAGE;
	}
}
