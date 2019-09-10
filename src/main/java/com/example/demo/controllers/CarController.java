package com.example.demo.controllers;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.CarModel;
import com.example.demo.model.DriverModel;
import com.example.demo.services.CarService;
import com.example.demo.services.DriverService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
//@RequestMapping("/car")
public class CarController {

	private static final String UPLOAD_FOLDER = "C:/Users/verizon/Desktop/Vicky/SpringCore/CabApplication/src/main/resources/images";
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private CarService carService;

	@GetMapping("/carIndex")
	public String greet() {
		System.out.println("Controller");
		return "Car Homepage";
	}
	
	
	//To be posted as form value only
	@PostMapping(value = "/addCar", produces="application/json", consumes = "multipart/form-data")
	public CarModel singleDriverUpload(@RequestParam("file") MultipartFile file, 
			@RequestParam("name") String name, @RequestParam("gender") String gender,
			@RequestParam("email") String email, @RequestParam("phoneNumber") String phoneNumber,
			@RequestParam("dob") String dob, @RequestParam("username") String username,
			@RequestParam("password") String password, @RequestParam("licenseNumber") String licenseNumber,

			@RequestParam("manufacturer") String manufacturer, @RequestParam("variant") String variant,
			@RequestParam("registrationNumber") String registrationNumber, @RequestParam("noOfSeaters") Integer noOfSeaters,
			@RequestParam("type") String type, @RequestParam("ratePerKm") Double ratePerKm
			) throws IOException, ParseException {
	
		
		DriverModel driverModel = new DriverModel();	
		CarModel carModel = new CarModel();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		driverModel.setDob(sdf.parse(dob));
		
		 // Creating the directory if doesn't exist to store file 
        File dir = new File(UPLOAD_FOLDER); 
        if (!dir.exists()) 
            dir.mkdirs();    
        
        //RandomNumber for picture
        // Generate random integers in range 0 to 999 
        Integer randInt = new Random().nextInt(10000);
               
        // Create the file on server 
        File serverFile = new File(dir + File.separator + randInt.toString()+file.getOriginalFilename()); 
        
        BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile)); 
        stream.write(file.getBytes());
        stream.close(); 
        
        //Set default values
        driverModel.setDriverPhotoLocation(serverFile.getAbsolutePath().toString());
		driverModel.setEmail(email);
		driverModel.setGender(gender);
		driverModel.setPhoneNumber(phoneNumber);
		
		driverModel.setLicenseNumber(licenseNumber);
		driverModel.setName(name);
		driverModel.setUsername(username);
		
		driverModel.setPassword(passwordEncoder.encode(password));
		driverModel.setRating(0.0); 
		driverModel.setTotalNoOfRatings(0);
		
		
		System.out.println(manufacturer+"====="+noOfSeaters);
		carModel.setDriver(driverModel);
		carModel.setManufacturer(manufacturer);
		carModel.setVariant(variant);
		carModel.setNoOfSeaters(noOfSeaters);
		carModel.setRatePerKm(ratePerKm);
		carModel.setType(type);
		carModel.setRegistrationNumber(registrationNumber);

		
		return carService.save(carModel);     
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
	
	@GetMapping(value = "/viewByType/{type}", produces="application/json" , consumes="application/json")
	public List<CarModel> findByType(@PathVariable String type) {	
		
		List<CarModel> carsList = new ArrayList<>();
		
		this.carService.findByType(type).forEach(eachObject -> {		
			Calendar calendar = Calendar.getInstance();
		    calendar.setTime(eachObject.getDriver().getDob());
		    calendar.add(Calendar.HOUR_OF_DAY, 6);
		    eachObject.getDriver().setDob(calendar.getTime());
			carsList.add(eachObject);
		});
		
		return carsList;
	}

	@GetMapping(value = "/deleteCar/{id}")
	public String deleteById(@PathVariable long id) throws IllegalArgumentException{			
		
		this.carService.deleteCarById(id);
		return "deleted the car";
	}
	
}
