package com.sunshine.rest.webservices.restfulwebservices.exception;

import java.util.function.Supplier;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException implements Supplier {

	public UserNotFoundException(String message) {
		super(message);
	}

	@Override
	public Object get() {
		return null;
	}

}
