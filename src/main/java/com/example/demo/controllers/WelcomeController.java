package com.example.demo.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/car")
public class WelcomeController {

	@GetMapping("/index")
	public String greet() {
		System.out.println("Controller");
		return "Car Homepage";
	}
}
