package com.cts.fse.car.rental.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.cts.fse.car.rental.controller.ManageInvDTO;
import com.cts.fse.car.rental.dto.FunctionResponseDTO;
import com.cts.fse.car.rental.entities.Inventory;
import com.cts.fse.car.rental.exceptions.CarRentalException;
import com.cts.fse.car.rental.repository.InventoryRepository;

@Service
public class ManageFleetService {
	@Autowired
	AppUserInfoService appUserInfoService;
	
	@Autowired
	InventoryRepository inventoryRepository;
	
	
	public List<Inventory> getFleetbyUser(){
		
		List<Inventory> invLst = new ArrayList<>();
		if(appUserInfoService.isUserHasRole("ROLE_ADMIN")) {
			invLst = inventoryRepository.findAll();
		}
		else {
			invLst = inventoryRepository.findInventoryCarbyUserId(appUserInfoService.getLoggedInUserObj().getId()).orElse(null);
		}
		return invLst;
	}
	
	public FunctionResponseDTO updateFleetId(ManageInvDTO manageInvDTO) throws CarRentalException {
	 try {	
		Inventory inv = inventoryRepository.findById(manageInvDTO.getInvId()).get();
		inv.setActive(manageInvDTO.getActiveflg().equalsIgnoreCase("Y"));
		inv.setMaxPassangers(manageInvDTO.getMaxPassanger());
		inv.setModel(manageInvDTO.getModel());
		inv.setBrand(manageInvDTO.getBrand());
		inv.setRentPerDay(Double.parseDouble(manageInvDTO.getDailyRent()));
		inventoryRepository.save(inv);
		return new FunctionResponseDTO("Successfully updated Inventory "+ manageInvDTO.getInvId(), true);
	 }
	 catch(DataAccessException de) {
		 throw new CarRentalException("Exception while updating inventory " + manageInvDTO.getInvId() ,de);
	 }
	}
}
