package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MVCController {
	@GetMapping("/index")
	public String greetingIndex() {

		return "index.html";
	}
	@GetMapping("/home")
	public String home() {

		return "home.html";
	} 
	@GetMapping("/calendar")
	public String calendar() {

		return "calendar.html";
	}
}
