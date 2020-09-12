package com.cts.fse.car.rental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cts.fse.car.rental.constants.CarRentalConstaants;
import com.cts.fse.car.rental.dto.AddInventoryDTO;
import com.cts.fse.car.rental.dto.FunctionResponseDTO;
import com.cts.fse.car.rental.exceptions.CarRentalException;
import com.cts.fse.car.rental.service.InventoryService;

@Controller
public class InventoryController {
	@Autowired
	InventoryService inventoryService;
	@GetMapping("/addcar")
	public String addacarToInventoryget(Model model) {
		model.addAttribute("invSuccessfull", false);
		model.addAttribute("invSuccessfailed",false);
		model.addAttribute("duplicateRegNo",false);
		model.addAttribute("addInventory", new AddInventoryDTO());		
		return CarRentalConstaants.ADD_CAR_PAGE;
	}
	
	@PostMapping("/addcar")
	public String addacarToInventory(Model model,@ModelAttribute AddInventoryDTO addInventory) throws CarRentalException {
		System.out.println(addInventory);
		if(inventoryService.checkInvAvalability(addInventory).isStatus()) {
			model.addAttribute("duplicateRegNo",true);
			model.addAttribute("invSuccessfailed",false);
			model.addAttribute("addInventory", addInventory);		
		}else {
		FunctionResponseDTO functionResponseDTO = inventoryService.addCarToInventory(addInventory);
		if(functionResponseDTO.isStatus()) {
		model.addAttribute("invSuccessfull", true);
		model.addAttribute("duplicateRegNo",false);
		}else {
		model.addAttribute("invSuccessfailed",false);
		}
		model.addAttribute("duplicateRegNo",false);
		model.addAttribute("addInventory", new AddInventoryDTO());	
		}
		return CarRentalConstaants.ADD_CAR_PAGE;
	}
	
	
}
