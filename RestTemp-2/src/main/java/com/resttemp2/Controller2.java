package com.resttemp2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
@RestController
public class Controller2 {
	
	@Autowired
	RestTemplate rest;
	
	@GetMapping(value="sayHiViaHello")
	public String getHello() {
		String str="http://localhost:8080/gethi";
		ResponseEntity<String> response= rest.exchange(str, HttpMethod.GET,null,String.class);
		String result= response.getBody();
		return result.toUpperCase();
	}

}
