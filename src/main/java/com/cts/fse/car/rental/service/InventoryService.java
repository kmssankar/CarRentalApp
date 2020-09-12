package com.cts.fse.car.rental.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.cts.fse.car.rental.dto.AddInventoryDTO;
import com.cts.fse.car.rental.dto.FunctionResponseDTO;
import com.cts.fse.car.rental.entities.Inventory;
import com.cts.fse.car.rental.entities.User;
import com.cts.fse.car.rental.exceptions.CarRentalException;
import com.cts.fse.car.rental.repository.InventoryRepository;
import com.cts.fse.car.rental.repository.UserRepository;

@Service
public class InventoryService implements IInventoryService {
	
	@Autowired 
	InventoryRepository inventoryRepository;
	@Autowired
	AppUserInfoService appUserInfoService;
	@Autowired
	UserRepository userRepository;
	
	@Override
	public FunctionResponseDTO addCarToInventory(AddInventoryDTO addInventoryDTO) throws CarRentalException{
		Inventory checkInv = inventoryRepository.findInventoryCarbyRegno(addInventoryDTO.getRegNo()).orElse(null);
		if(checkInv==null) {
		Inventory inventory = new Inventory();
		inventory.setActive(true);
		inventory.setBrand(addInventoryDTO.getBrand());
		inventory.setCarType(addInventoryDTO.getCarType());
		inventory.setFuel(addInventoryDTO.getFuel());
		inventory.setModel(addInventoryDTO.getModel());
		inventory.setMaxPassangers(addInventoryDTO.getMaxPassangers());
		inventory.setAvgMileage(addInventoryDTO.getAvgMileage());
		inventory.setRegNo(addInventoryDTO.getRegNo());
		inventory.setRentPerDay(addInventoryDTO.getRentPerDay());
		User user = appUserInfoService.getLoggedInUserObj();
		System.out.println("User "+user.getId() +" name" + user.getUserName());
		inventory.setUser(userRepository.findById(user.getId()).get());
		
		try {
		inventoryRepository.save(inventory);
		return new FunctionResponseDTO("Car added successfully ", true);
		}
		catch(DataAccessException d) {
			throw new CarRentalException("Exception while saving new car to Inventory "+ d);
		}
		}
		else {
			return new FunctionResponseDTO("Car already present in the Inventory ", false);
		}
	}


	@Override
	public FunctionResponseDTO checkInvAvalability( AddInventoryDTO addInventoryDTO) throws CarRentalException  {
		try {
		Inventory checkInv = inventoryRepository.findInventoryCarbyRegno(addInventoryDTO.getRegNo()).orElse(null);
		return new FunctionResponseDTO("Reponse Message ", (checkInv!=null));
		}
		catch(DataAccessException d) {
			throw new CarRentalException("Exception while deactivating the vehicle "+ d);
		}
	}

	@Override
	public FunctionResponseDTO activateVehicle(Integer inventoryId) throws CarRentalException {
		try {
			Inventory inventory = inventoryRepository.findById(inventoryId).orElseGet(null);
			inventory.setActive(true);
			inventoryRepository.save(inventory);
			return new FunctionResponseDTO("Car acivated successfully ", true);
		}
		catch(DataAccessException d) {
			throw new CarRentalException("Exception while deactivating the vehicle "+ d);
		}
	}



	@Override
	public FunctionResponseDTO deactiveVehicle(Integer inventoryId) throws CarRentalException {
		try {
			Inventory inventory = inventoryRepository.findById(inventoryId).orElseGet(null);
			inventory.setActive(false);
			inventoryRepository.save(inventory);
			return new FunctionResponseDTO("Car Deactivted successfully ", true);
		}
		catch(DataAccessException d) {
			throw new CarRentalException("Exception while deactivating the vehicle "+ d);
		}
	}



	@Override
	public FunctionResponseDTO modifyCarinInventory(AddInventoryDTO addInventoryDTO) throws CarRentalException {
		try {
		Inventory inventory = inventoryRepository.findById(addInventoryDTO.getId()).orElseGet(null);
		if(inventory != null) {
		inventory.setActive(true);
		inventory.setBrand(addInventoryDTO.getBrand());
		inventory.setCarType(addInventoryDTO.getCarType());
		inventory.setFuel(addInventoryDTO.getFuel());
		inventory.setModel(addInventoryDTO.getModel());
		inventory.setMaxPassangers(addInventoryDTO.getMaxPassangers());
		inventory.setAvgMileage(addInventoryDTO.getAvgMileage());
		inventory.setRegNo(addInventoryDTO.getRegNo());
		inventory.setRentPerDay(addInventoryDTO.getRentPerDay());
		inventoryRepository.save(inventory);
		return new FunctionResponseDTO("Car updated successfully ", true);
		}
		else {
			return new FunctionResponseDTO("Error in updating the inventory ! car is not available in Inventory", false);
		}
		
		}catch(DataAccessException d) {
			throw new CarRentalException("Exception while saving new car to Inventory "+ d);
		}
		
	}
		

}
