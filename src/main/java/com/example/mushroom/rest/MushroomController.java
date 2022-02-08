package com.example.mushroom.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	//Read by ID (GET)
		@GetMapping("/getOne/{id}")
		public Mushrooms getOne(@PathVariable int id){
			return this.mushroom.get(id);
			
}
		
		@GetMapping("/getAll")
		public List<Mushrooms> getAll(){
			return this.mushroom;
					
		}
		//Update - PUT
		//create, read by id
		@PutMapping("/updateMushroom/{id}")
		public Mushrooms updateMushroom(@PathVariable int id, @RequestBody Mushrooms mh) {
		//remove mushroom by id
		
			this.mushroom.set(id, mh);
			return this.mushroom.get(id);
		}
		
		//Delete - DELETE
		@DeleteMapping("/removeMushroom/{id}")
		public Mushrooms removeMushroom(@PathVariable int id) {
			return this.mushroom.remove(id);
		}
		
}
