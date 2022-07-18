package com.example.demo.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ActorServicePostRequestRunner implements CommandLineRunner{

	@Override
	public void run(String... args) throws Exception {
		RestTemplate template = new RestTemplate();
		String serviceUrl = "http://localhost:8081/actor/register";
		
		//prepare JSON data: (request Body)
		String josnData = "{ \"aid\":1001, \"name\":\"Suresh\", \"age\":30.0,\"type\":\"hero\"}";
		
		//prepare http headers:
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		//preapare http HttpRequest as HttpEntity object as Head, body
		HttpEntity<String>request = new HttpEntity<String>(josnData,headers);
		
		// make http request call in POST mode
		ResponseEntity<String> response = template.postForEntity(serviceUrl, request, String .class);
		System.out.println("Response Body:(Output):: " + response.getBody());
		System.out.println("Response Status:(Output):: " + response.getStatusCodeValue()); // as a Integer we will get
		System.out.println("Response Status Code Value:(Output):: " + response.getStatusCode().name());
		System.out.println("Response Status Is ClientError:(Output):: " + response.getStatusCode().is4xxClientError());
		
	}

}

/*
 Post Mode request contains:
 	RequestBody
 	Request Headers
 	and Request Line (Initial Line)
 	
 Every Request Structure contains two parts: 
 	HeadPart (initial lines + request Headers)
 	Body Part (Payload Part) nothing but request body
 	
 
*/
