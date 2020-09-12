package com.cts.fse.car.rental.service;

import com.cts.fse.car.rental.exceptions.CarRentalException;

public interface IRoleManagementService {

	public boolean giveVendorAccess(int id) throws CarRentalException;

	public boolean deactiveAccount(int id) throws CarRentalException;

	public boolean activeAccount(int id) throws CarRentalException;

}
