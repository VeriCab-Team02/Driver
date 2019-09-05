package com.example.demo.controllers;


import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.DriverModel;
import com.example.demo.model.CarModel;
import com.example.demo.services.CarService;

@RestController
@RequestMapping("/car")
public class WelcomeController {

	private static final String UPLOADED_FOLDER = "C:/Users/verizon/Desktop/Vicky/SpringCore/CabApplication/src/main/resources/images";
	@Autowired
	private CarService service;
	
	
	@GetMapping("/index")
	public String greet() {
		System.out.println("Controller");
		return "Car Homepage";
	}
	
	@PostMapping(value = "/driverRegister", produces="application/json" , consumes="application/json")
	public String singleDriverUpload(@RequestParam("file") MultipartFile file,
			@Valid @ModelAttribute DriverModel driver) {
		
		
		return "";
	}
	
//	@PostMapping(value = "/addBooking", produces="application/json" , consumes="application/json")
//	public Booking addBooking(@RequestBody Booking booking) {
//		
//		return this.service.save(booking);
//	}
//	
//	@PostMapping(value = "/updateBooking", produces="application/json" , consumes="application/json")
//	public Booking updateBooking(@RequestBody Booking booking) {
//		
//		return this.service.save(booking);
//	}
//	
//	@GetMapping(value = "/viewBookings")
//	public List<Booking> findAll() {
//		
//		List<Booking> fliList = new ArrayList<>();
//		
//		this.service.findAll().forEach(eachObject -> {
//			fliList.add(eachObject);
//		});
//		
//		return fliList;
//	}
}
