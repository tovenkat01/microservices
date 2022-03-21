package com.sunshine.rest.webservices.restfulwebservices.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExceptionResponse {
	private LocalDateTime timestamp;
	private String message;
	private String details;
}
