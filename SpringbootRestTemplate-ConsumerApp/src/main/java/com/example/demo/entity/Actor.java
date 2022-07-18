package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Actor {
	
	private Integer aid;
	private String aname;
	private Float age;
	private String type;
}
