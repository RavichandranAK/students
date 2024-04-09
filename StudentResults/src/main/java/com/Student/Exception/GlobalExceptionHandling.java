package com.Student.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandling {
	
	@ExceptionHandler(value=NoValueException.class)
	public ResponseEntity<Object> NoValueExceptionHandler(NoValueException no) {
		return new ResponseEntity<>(no.getMessage(),HttpStatus.BAD_REQUEST);
	}

}
