package com.example.model.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImplementation implements GreetingService {

	@Override
	public String greeting() {
		return "Hamza";
	}
}