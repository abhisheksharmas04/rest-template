package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.Tourist;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class TouristOperationConsumerController {
	
	@Autowired
	private RestTemplate template;

	@GetMapping("/")
	public String showHome() {
		return "home"; // Logical View Name: 
	}
	
	@GetMapping("/list_tourist")
	public ResponseEntity<List<Tourist>> displayTouristReport(Map<String,Object> map) throws JsonMappingException, JsonProcessingException{
		// consume Spring rest service/method or operation
		
		String serviceUrl = "http://localhost:4040/RestMiniProject/tourist/findAll";
		ResponseEntity<String>resp = template.exchange(serviceUrl,HttpMethod.GET,null,String.class);
		String jsonResponseBody = resp.getBody();
		
		//Conver string response body to List<Tourist>
		ObjectMapper mapper = new ObjectMapper();
		List<Tourist>toursitList = mapper.readValue(jsonResponseBody,new TypeReference<List<Tourist>>() {});
		
		// Keep results in MAP collection as Model Attributes
		map.put("touristList", toursitList);
		
		// return logical view Name
		return new ResponseEntity<List<Tourist>>(toursitList, HttpStatus.OK);
	}
}
