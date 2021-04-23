package com.tekton.greetingservice;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.tekton.greetingservice.application.controller.GreetingController;

class GreetingControllerTest {
	
	private GreetingController greetingController;
	
	@BeforeEach
	public void setup() {
		greetingController = new GreetingController();
	}

	@Test
	void fetchesGreetingsFromTheController() {
		String greetings = greetingController.fetchGreeting("John Doe");
		assertThat(greetings).isEqualTo("Hello John Doe");
	}

}
