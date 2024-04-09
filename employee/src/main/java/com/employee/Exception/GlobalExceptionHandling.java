package com.employee.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandling {

	@ExceptionHandler(value = NonameException.class)
	public ResponseEntity<Object> NonameExceptionHandling(NonameException non) {
		return new ResponseEntity<>(non.getMessage(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = AgeException.class)
	public ResponseEntity<Object> AgeExceptionHandling(AgeException age) {
		return new ResponseEntity<>(age.getMessage(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = NewAgeException.class)
	public ResponseEntity<Object> NewAgeExceptionHandling(NewAgeException newage) {
		return new ResponseEntity<>(newage.getMessage(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = NullPointerException.class)
	public ResponseEntity<Object> NullPointerExceptionHandling(NullPointerException nul) {
		return new ResponseEntity<>(nul.getMessage(), HttpStatus.BAD_REQUEST);
	}

}
