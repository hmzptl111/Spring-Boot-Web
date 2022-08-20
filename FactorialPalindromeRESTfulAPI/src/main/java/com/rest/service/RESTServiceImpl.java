package com.rest.service;

import org.springframework.stereotype.Service;

@Service
public class RESTServiceImpl implements RESTService {

	@Override
	public int factorial(int number) {
		if(number == 1) return 1;
		
		return number * factorial(number - 1);
	}

	@Override
	public boolean isPalindrome(int number) {
		int result = 0, temp = number;
		
		while(temp > 0) {
			result *= 10;
			result += temp % 10;
			temp /= 10;
		}

		return (number == result);
	}

}
