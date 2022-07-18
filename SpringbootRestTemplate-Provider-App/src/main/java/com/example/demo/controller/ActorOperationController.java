package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Actor;

@RestController
@RequestMapping("/actor")
public class ActorOperationController {
	
	/*@GetMapping("/wish")
	public ResponseEntity<String> getWishMessage(){
		return new ResponseEntity<String>("Good Morning", HttpStatus.OK);
	}*/
	
	@GetMapping("/wish/{id}/{name}")
	public ResponseEntity<String> getWishMessage(@PathVariable Integer id, @PathVariable String name){
		return new ResponseEntity<String>("Good Morning.." + id + " " + name, HttpStatus.OK);
	}
	
	@PostMapping("/register")
	public ResponseEntity<String> registerActor(@RequestBody Actor actor){
		return new ResponseEntity<String>("actor data : " + actor.toString(), HttpStatus.OK);
	}

	@GetMapping("/findAll")
	public ResponseEntity<List<Actor>>fetchAllActors(){
		return new ResponseEntity<List<Actor>>(List.of(new Actor(101,"Salman",55.0f,"Hero"), 
				new Actor(102,"Rajesh", 60.0f, "Hero"), new Actor(103,"Ranveer",45.0f,"Hero"), new Actor(104, "Alia", 35.0f, "Heroien")),HttpStatus.OK);
	}

}
