package com.bit.project.article.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	
	@GetMapping("/")
	@CrossOrigin(origins = "*", exposedHeaders = "Authorization")
	public void root() {
		
	}

}
