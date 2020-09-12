package com.cts.fse.car.rental.service;

import com.cts.fse.car.rental.dto.AddInventoryDTO;
import com.cts.fse.car.rental.dto.FunctionResponseDTO;
import com.cts.fse.car.rental.exceptions.CarRentalException;

public interface IInventoryService {

	public FunctionResponseDTO addCarToInventory(AddInventoryDTO addInventoryDTO) throws CarRentalException;
	
	public FunctionResponseDTO activateVehicle(Integer inventoryId) throws CarRentalException;
	
	public FunctionResponseDTO deactiveVehicle(Integer inventoryId) throws CarRentalException;
	
	public FunctionResponseDTO modifyCarinInventory(AddInventoryDTO addInventoryDTO) throws CarRentalException;

	FunctionResponseDTO checkInvAvalability(AddInventoryDTO addInventoryDTO) throws CarRentalException;
}
