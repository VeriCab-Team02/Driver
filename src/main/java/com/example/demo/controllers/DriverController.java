package com.example.demo.controllers;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.CurrentLocation;
import com.example.demo.model.DriverModel;
import com.example.demo.services.DriverService;

@RestController
//@RequestMapping("/driver")
public class DriverController {

	private static final String UPLOAD_FOLDER = "C:/Users/verizon/Desktop/Vicky/SpringCore/CabApplication/src/main/resources/images";
	
	@Autowired
	private DriverService service;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@GetMapping("/index")
	public String greet() {
		System.out.println("Controller");
		return "Car Homepage";
	}
	
	
	//To be posted as form value only
	@PostMapping(value = "/addDriver", produces="application/json", consumes = { "multipart/form-data" })
	public String singleDriverUpload(@RequestParam("file") MultipartFile file,
			@Valid @ModelAttribute DriverModel entity) throws IOException {

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
        entity.setDriverPhotoLocation(serverFile.getAbsolutePath().toString());
        entity.setRating(0.0);
        entity.setTotalNoOfRatings(0);

        //Encode the password
        entity.setPassword(passwordEncoder.encode(entity.getPassword()));
        
        service.save(entity);
        
		return "success";
	}
	

	@GetMapping(value = "/viewDrivers", produces="application/json")
	public List<DriverModel> findAll() {
		
		List<DriverModel> driversList = new ArrayList<>();
		
		this.service.findAll().forEach(eachObject -> {
			
			Calendar calendar = Calendar.getInstance();
		    calendar.setTime(eachObject.getDob());
		    calendar.add(Calendar.HOUR_OF_DAY, 6);
		    eachObject.setDob(calendar.getTime());
			driversList.add(eachObject);});
		
		return driversList;
	}
	
	
	//Post as JSON values only
	@PostMapping(value = "/updateDriver/{id}", produces="application/json" , consumes="application/json")
	public DriverModel updateDriver(@PathVariable Long id, @Valid @RequestBody DriverModel driver ) {
		
		//Can update name, gender, email,phone number, username, password, licenseNumber
		DriverModel dm = this.service.findById(id);
		driver.setDriverId(id);
		driver.setDriverPhotoLocation(dm.getDriverPhotoLocation());
		driver.setRating(dm.getRating());
		
		
		driver.setTotalNoOfRatings(dm.getTotalNoOfRatings());
		driver.setPassword(passwordEncoder.encode(driver.getPassword()));
		
		//updating the driver value
		driver = this.service.save(driver);
		
		
		//Correcting the date before sending the value
		Calendar calendar = Calendar.getInstance();
	    calendar.setTime(dm.getDob());
	    calendar.add(Calendar.HOUR_OF_DAY, 6);  
		driver.setDob(calendar.getTime());
		return driver;
	}
	
	
	@GetMapping(value = "/viewDriver/{driverId}", produces="application/json" , consumes="application/json")
	public DriverModel findById(@PathVariable long driverId) {	
		
		return this.service.findById(driverId);
	}

	@GetMapping(value = "/deleteDriver/{id}")
	public String deleteById(@PathVariable long id) throws IllegalArgumentException{			
		
		this.service.deleteDriverById(id);
		return "deleted";
	}
	
	@PostMapping(value = "/rateDriver/{id}/{rating}", produces="application/json")
	public DriverModel rateBooking(@PathVariable("id") Long id, @PathVariable("rating") Double rating) {

		DriverModel driver = this.service.findById(id);
		
		//Rating formula using mean values
		Double calc =  (( driver.getRating() * driver.getTotalNoOfRatings() ) + rating ) / (driver.getTotalNoOfRatings() + 1 );
		
		//update latest rating for this driver
		driver.setRating(calc);
		
		//updating the user's count
		driver.setTotalNoOfRatings(driver.getTotalNoOfRatings()+1);
		
		return this.service.save(driver);
	}
	
	
}
