package com.example.demo.controllers;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
	private static Integer picId = 0;
	
	@Autowired
	private DriverService service;
	
	@GetMapping("/index")
	public String greet() {
		System.out.println("Controller");
		return "Car Homepage";
	}
	
	@PostMapping(value = "/addDriver", produces="application/json", consumes = { "multipart/form-data" })
	public String singleDriverUpload(@RequestParam("file") MultipartFile file,
			@Valid @ModelAttribute DriverModel entity) throws IOException {

        // Creating the directory to store file 
        File dir = new File(UPLOAD_FOLDER); 
        if (!dir.exists()) 
            dir.mkdirs();    
        
        // Create the file on server 
        File serverFile = new File(dir + File.separator + picId.toString()+file.getOriginalFilename()); 
        picId++;
        
        BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile)); 
        stream.write(file.getBytes());
        stream.close(); 
        
        //System.out.println("Server File Location=" + serverFile.getAbsolutePath());
        
        entity.setDriverPhotoLocation(serverFile.getAbsolutePath().toString());
        entity.setRating(0.0);
        entity.setTotalNoOfRatings(0);

        
        service.save(entity);
        
		return "success";
	}
	

	@GetMapping(value = "/viewDrivers", produces="application/json" , consumes="application/json")
	public List<DriverModel> findAll() {
		
		List<DriverModel> driversList = new ArrayList<>();
		
		this.service.findAll().forEach(eachObject -> {
			driversList.add(eachObject);
		});
		
		return driversList;
	}
	
	@PostMapping(value = "/updateDriver", produces="application/json" , consumes="application/json")
	public DriverModel updateBooking(@RequestParam("file") MultipartFile file,
			@Valid @ModelAttribute DriverModel driver ) {

		return this.service.save(driver);
	}
	
	
	@GetMapping(value = "/viewDriver/{id}", produces="application/json" , consumes="application/json")
	public DriverModel findById(@PathVariable long id) {	
		
		return this.service.findById(id);
	}

	@GetMapping(value = "/deleteDriver/{id}")
	public String deleteById(@PathVariable long id) throws IllegalArgumentException{			
		
		this.service.deleteDriverById(id);
		return "deleted";
	}
	
	@PostMapping(value = "/rateDriver/{id}/{rating}", produces="application/json" , consumes="application/json")
	public DriverModel rateBooking(@PathVariable long id, @PathVariable Integer rating) {

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
