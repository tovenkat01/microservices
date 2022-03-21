package com.sunshine.rest.webservices.restfulwebservices.controller;

import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.sunshine.rest.webservices.restfulwebservices.model.SomeBean;
import com.sunshine.rest.webservices.restfulwebservices.model.SomeBean2;

@RestController
public class FilteringController {

	@GetMapping("/static-filtering")
	public SomeBean retriveSomeBean() {
		return new SomeBean("value1", "value2", "value3");
	}

	@GetMapping("/static-filtering-list")
	public List<SomeBean> retriveListOfSomeBean() {
		return List.of(new SomeBean("value1", "value2", "value3"), new SomeBean("value12", "value22", "value32"));
	}

	@GetMapping("/dynamic-filtering")
	public MappingJacksonValue retriveSomeBean2() {
		var someBean2 = new SomeBean2("value1", "value2", "value3");
		var simpleBeanPropertyFilter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field2");
		var filterProvider = new SimpleFilterProvider().addFilter("SomeBeanFilter", simpleBeanPropertyFilter);
		var mappingJacksonValue = new MappingJacksonValue(someBean2);
		mappingJacksonValue.setFilters(filterProvider);
		return mappingJacksonValue;
	}

	@GetMapping("/dynamic-filtering-list")
	public MappingJacksonValue retriveListOfSomeBean2() {
		var someBeans = List.of(new SomeBean2("value1", "value2", "value3"), new SomeBean2("value12", "value22", "value32"));
		var simpleBeanPropertyFilter = SimpleBeanPropertyFilter.filterOutAllExcept("field2", "field3");
		var filterProvider = new SimpleFilterProvider().addFilter("SomeBeanFilter", simpleBeanPropertyFilter);
		var mappingJacksonValue = new MappingJacksonValue(someBeans);
		mappingJacksonValue.setFilters(filterProvider);
		return mappingJacksonValue;
	}
}
