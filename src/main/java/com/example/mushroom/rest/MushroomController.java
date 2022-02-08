package com.example.mushroom.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.mushroom.domain.Mushrooms;

@RestController
public class MushroomController {

private List<Mushrooms> mushroom = new ArrayList<>();
	
	
	//Response entity: allows us to configure the status code of response
	//CRUD

	//Create - POST
	//Response to return instead of 200: 201- created
	@PostMapping("/createMushroom")
	public ResponseEntity<Mushrooms> createMushroom(@RequestBody Mushrooms m) {
		//service > create
		this.mushroom.add(m);
		//get the record 
		Mushrooms newMushroom = this.mushroom.get(this.mushroom.size()-1);
		return new ResponseEntity<Mushrooms>(newMushroom, HttpStatus.CREATED);
	}
}
