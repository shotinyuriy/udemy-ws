package com.udemy.microservice.rest01.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {

	@GetMapping("/filtering/some-bean")
	public MappingJacksonValue getSomeBean() {
		SomeBean someBean = new SomeBean("value1", "value2", "value3");
		
		FilterProvider filters = createFilter("filter-01", "field1", "field2");
		
		MappingJacksonValue mapping = new MappingJacksonValue(someBean);
		mapping.setFilters(filters);
		
		return mapping;
	}
	
	@GetMapping("filtering/some-beans")
	public MappingJacksonValue getSomeBeans() {
		FilterProvider filters = createFilter("filter-01", "field2", "field3");
	
		List<SomeBean> someBeans = Arrays.asList(
				new SomeBean("value1", "value2", "value3"),
				new SomeBean("value4", "value5", "value6")
		);
		
		MappingJacksonValue mapping = new MappingJacksonValue(someBeans);
		mapping.setFilters(filters);
		return mapping;
	}
	
	public static FilterProvider createFilter(String filterName, String... fieldNames) {
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
				.filterOutAllExcept(fieldNames);
		
		FilterProvider filters = new SimpleFilterProvider()
				.addFilter(filterName, filter);
		
		return filters;
	}
}
