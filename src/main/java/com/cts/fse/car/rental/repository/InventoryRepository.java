package com.cts.fse.car.rental.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cts.fse.car.rental.entities.Inventory;
@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Integer> {
	
	@Query("select  i from Inventory i where i.id not in (select cb.inventoryId from CarBooking cb where ( cb.bookingFrom between"
			+ " :fromDt and :toDt ) or (cb.bookingTo between :fromDt and :toDt ) )"
			+ " and i.carType = :type and i.maxPassangers >= :noofpass and i.active = true")
	public List<Inventory> findAvailablebasedOndate(Date fromDt, Date toDt ,String type , int noofpass);
	
	
	@Query("Select i from Inventory i where i.regNo = :regNo")
	public Optional<Inventory> findInventoryCarbyRegno(String regNo);
	
	@Query("select  i from Inventory i where i.id = :Invid and i.id not in (select cb.inventoryId from CarBooking cb where ( cb.bookingFrom between " + 
			" :fromDt and :toDt ) or (cb.bookingTo between :fromDt and :toDt ) )")			
	public Inventory validateAvailablebasedOndate(Date fromDt, Date toDt ,int Invid);
	
	
	@Query(value="Select i.* from Inventory i where i.user_id = :userId" ,nativeQuery = true)
	public Optional< List<Inventory>> findInventoryCarbyUserId(int  userId);

}
