package com.example.demo.controllers;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.CarModel;
import com.example.demo.services.CarService;

@RestController
//@RequestMapping("/car")
public class CarController {

	@Autowired
	private CarService carService;

	@GetMapping("/carIndex")
	public String greet() {
		System.out.println("Controller");
		return "Car Homepage";
	}
	
	
	//To be posted as form value only
	@PostMapping(value = "/addCar", produces="application/json", consumes = "application/json")
	public String singleDriverUpload(@Valid @RequestBody CarModel entity) throws IOException {
	
        this.carService.save(entity);       
		return "successfully added the car";
	}
	

	@GetMapping(value = "/viewCars", produces="application/json")
	public List<CarModel> findAll() {
		
		List<CarModel> carsList = new ArrayList<>();
		
		this.carService.findAll().forEach(eachObject -> {
			
			Calendar calendar = Calendar.getInstance();
		    calendar.setTime(eachObject.getDriver().getDob());
		    calendar.add(Calendar.HOUR_OF_DAY, 6);
		    eachObject.getDriver().setDob(calendar.getTime());
			carsList.add(eachObject);});
		
		return carsList;
	}
	
	
	//Post as JSON values only
	@PostMapping(value = "/updateCar/{id}", produces="application/json" , consumes="application/json")
	public CarModel updateCar(@PathVariable Long id, @Valid @RequestBody CarModel car ) {
		
		CarModel cm = this.carService.findById(id);
		car.setCarId(id);
		car.setDriver(cm.getDriver());
		
		//updating the driver value
		return this.carService.save(car);
	}
	
	
	@GetMapping(value = "/viewCar/{carId}", produces="application/json" , consumes="application/json")
	public CarModel findById(@PathVariable long carId) {	
		
		CarModel cm = this.carService.findById(carId);
		Calendar calendar = Calendar.getInstance();
	    calendar.setTime(cm.getDriver().getDob());
	    calendar.add(Calendar.HOUR_OF_DAY, 6);
	    cm.getDriver().setDob(calendar.getTime());
		return cm;
	}

	@GetMapping(value = "/deleteCar/{id}")
	public String deleteById(@PathVariable long id) throws IllegalArgumentException{			
		
		this.carService.deleteCarById(id);
		return "deleted the car";
	}
	
}
