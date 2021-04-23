package com.tekton.greetingservice.application.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class GreetingController {

	@GetMapping("/greeting")
	public String fetchGreeting(@RequestParam String name) {
		return "Hello "+name;
	}

}
