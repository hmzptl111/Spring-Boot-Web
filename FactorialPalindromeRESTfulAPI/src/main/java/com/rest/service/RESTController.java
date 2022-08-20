package com.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RESTController {
	
	@Autowired
	private RESTService restService;
	
	@GetMapping(path = "/factorial/{number}", produces = MediaType.TEXT_PLAIN_VALUE)
	public String getFactorial(@PathVariable("number") String number) {
		return Integer.toString(restService.factorial(Integer.parseInt(number)));
	}
	
	@GetMapping(path = "/palindrome/{number}", produces = MediaType.TEXT_PLAIN_VALUE)
	public String getPalindrome(@PathVariable("number") String number) {
		boolean isPalindrome = restService.isPalindrome(Integer.parseInt(number));
		return (isPalindrome) ? number + " is a palindrome": number + " is not a palindrome";
	}
}
