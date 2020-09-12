package com.cts.fse.car.rental.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.cts.fse.car.rental.constants.CarRentalConstaants;

@Controller					
public class HomeController {
	
	
	@GetMapping("/")
	public String getHomePage() {
		
		return CarRentalConstaants.HOME_PAGE;
	}
}
