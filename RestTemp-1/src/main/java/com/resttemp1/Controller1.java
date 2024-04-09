package com.resttemp1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller1 {
	@GetMapping(value="/gethi")
	public String getHi() {
		return "i am an engineer";
	}

}
