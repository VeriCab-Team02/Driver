package com.example.demo.controllers;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.DriverModel;
import com.example.demo.services.DriverService;

@RestController
//@RequestMapping("/car")
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
	
	@PostMapping(value = "/driverRegister", produces="application/json", consumes = { "multipart/form-data" })
	public String singleDriverUpload(@RequestParam("file") MultipartFile file,
			@Valid @ModelAttribute DriverModel entity) throws IOException {
		
        byte[] bytes = file.getBytes();     

        Path path = Paths.get(UPLOAD_FOLDER + file.getOriginalFilename());
        Files.write(path, bytes);
        // Creating the directory to store file 
        File dir = new File(UPLOAD_FOLDER); 
        if (!dir.exists()) 
            dir.mkdirs();    
        
        // Create the file on server 
        File serverFile = new File(dir.getAbsolutePath() + File.separator + picId.toString()); 
        picId++;
        
        BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile)); 
        stream.write(bytes);
        stream.close(); 
        System.out.println("Server File Location=" + serverFile.getAbsolutePath());
        entity.setDriverPhotoLocation(picId.toString()+dir.getAbsolutePath().toString());
        service.save(entity);
        
		return "success";
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
