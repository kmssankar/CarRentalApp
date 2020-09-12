package com.cts.fse.car.rental.constants;

public class CarRentalConstaants {
	
	public static final String HOME_PAGE ="home";
	public static final String ACTIVE_FLAG_Y ="Y";
	public static final String REGISTER_PAGE ="register";
	public static final String LOGIN_PAGE ="login";
	public static final String ADD_CAR_PAGE ="addacar";
	public static final String BOOK_CAR_PAGE ="searchcars";
	public static final String MANAGE_USER_PAGE ="ManageUser";
	public static final String CONFIRM_BOOKING_PAGE ="confirmbooking";
	public static final String MY_BOOKING_PAGE ="mybookings";
	public static final String MY_RETURN_PAGE ="confirmreturncar";
	public static final String REVIEW_PAGE ="reviewpage";
	public static final String MANAGE_ROLES_PAGE ="manageroles";
	public static final String MANAGE_ROLES_RESP_PAGE ="manageRoleResponse";
	public static final String MANAGE_FLEET_PAGE ="managefleet";
	public static final String MANAGE_FLEET_RESP_PAGE ="manageFleetResponse";
	public static final String BOOK_GET_URL ="./confirmBooking?id=:id&fromdt=:fromdt&toDate=:todt";
	
	
	//Queries 
	public static final String REVIEW_QUERY = "select Avg(cr.rating) as avgRating, count(cr.id ) as count , i.model as model , i.reg_no as regno , i.brand  as brand from  " + 
			"car_reviews cr  , " + 
			"car_booking cb , " + 
			"inventory i , " + 
			"user u " + 
			"where cr.booking_id = cb.id  " + 
			"and cb.inventory_id = i.id  " + 
			"and i.user_id = u.id  " + 
			"and u.id= ? group by i.model , i.reg_no  , i.brand";
	
	public static final String REVIEW_QUERY_ADMIN = "select Avg(cr.rating) as avgRating, count(cr.id ) as count , i.model as model , i.reg_no as regno , i.brand  as brand from  " + 
			"car_reviews cr  , " + 
			"car_booking cb , " + 
			"inventory i , " + 
			"user u " + 
			"where cr.booking_id = cb.id  " + 
			"and cb.inventory_id = i.id  " + 
			"and i.user_id = u.id  group by i.model , i.reg_no  , i.brand";

}
