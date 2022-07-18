package com.example.demo.runner;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.Actor;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ActorServiceConsumerRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		// Create RestTemplate class object:
		RestTemplate template = new RestTemplate();
		
		//define url
		String serviceurl = "http://localhost:8081/actor/wish/{id}/{name}";
		
		//generate http request call with get mode to consume the web service:
		//ResponseEntity<String>response = template.getForEntity(serviceurl,String.class);
		
		// display the received details from the response
		/*System.out.println("Response Body:(Output):: " + response.getBody());
		System.out.println("Response Status:(Output):: " + response.getStatusCodeValue()); // as a Integer we will get
		System.out.println("Response Status Code Value:(Output):: " + response.getStatusCode().name());
		System.out.println("Response Status Code Value:(Output):: " + response.getStatusCode().is4xxClientError());*/
		
		//-----------------------Get Object-------------------------------------------------------------------------
		/*Object obj = template.getForObject(serviceurl, String.class); // This will give only reponse body no status code
		System.out.println("Reponse Body:  " + obj); */
		
		//System.exit(0); // optional not mandatory
		
		//---------------------Passing PathVariables in http calls using RestTemplate-----------------------------------
		
		/*
		 	Both getForObject() and getForEntity() methods are having multiple overloaded form that is taking more param
		 	is maintaining last param as var args param which is given to pass any no of path variable along with the 
		 	http request
		 */
//		ResponseEntity<String>response = template.getForEntity(serviceurl, String.class, 1001, "Raja");
		/*ResponseEntity<String>response = template.getForEntity(serviceurl, String.class, Map.of("id",1010,"name","raja"));
		System.out.println("Response Body:(Output):: " + response.getBody());
		System.out.println("Response Status:(Output):: " + response.getStatusCodeValue()); // as a Integer we will get
		System.out.println("Response Status Code Value:(Output):: " + response.getStatusCode().name());
		System.out.println("Response Status Is ClientError:(Output):: " + response.getStatusCode().is4xxClientError());*/
		//System.out.println("Response Status Code Value:(Output):: " + response.getHeaders().toString());
		
		//---------------------------Get List of Json Data---------------------------------------------------------
		serviceurl = "http://localhost:8081/actor/findAll";
		ResponseEntity<String>resp = template.exchange(serviceurl,HttpMethod.GET, null, String.class);
		String jsonBody = resp.getBody();
		ObjectMapper mapper = new ObjectMapper();
		Actor[] actors = mapper.readValue(jsonBody,Actor[].class);
		List<Actor> actorsList = Arrays.asList(actors);
		System.out.println("Reponse Body as List actors object Data: " );
		actorsList.forEach(System.out::println);
		
		// DIrect Method:
		List<Actor>list1 = mapper.readValue(jsonBody,new TypeReference<List<Actor>>(){});
		list1.forEach(System.out::println);
	}

}
