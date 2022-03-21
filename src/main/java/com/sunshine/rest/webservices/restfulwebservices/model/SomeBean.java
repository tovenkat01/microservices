package com.sunshine.rest.webservices.restfulwebservices.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;

@JsonIgnoreProperties(value = {"field2"})
@Data
@AllArgsConstructor
public class SomeBean {
	private String field1;
	private String field2;
	@JsonIgnore
	private String field3;
}
