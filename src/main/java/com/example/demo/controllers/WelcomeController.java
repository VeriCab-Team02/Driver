package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class WelcomeController {

	@GetMapping("/heading")
	public String greet() {
		
		return "Car Homepage";
	}
}
