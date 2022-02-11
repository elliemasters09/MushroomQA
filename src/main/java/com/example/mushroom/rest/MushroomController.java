package com.example.mushroom.rest;

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
import com.example.mushroom.service.MushroomService;

@RestController
public class MushroomController {

	private MushroomService service;

	public MushroomController(MushroomService service) {
		this.service = service;
	}

	// Response entity: allows us to configure the status code of response
	// CRUD

	// Create - POST
	// Response to return instead of 200: 201- created
	@PostMapping("/createMushroom")
	public ResponseEntity<Mushrooms> createMushroom(@RequestBody Mushrooms mushroom) {

		return new ResponseEntity<Mushrooms>(this.service.create(mushroom), HttpStatus.CREATED);
	}

	// Read by ID (GET)
	@GetMapping("/getOne/{id}")
	public ResponseEntity<Mushrooms> getOne(@PathVariable Long id) {

		return new ResponseEntity<Mushrooms>(this.service.getById(id), HttpStatus.OK);

	}

	@GetMapping("/getAll")
	public ResponseEntity<List<Mushrooms>> getAll() {
		return new ResponseEntity<List<Mushrooms>>(this.service.getAll(), HttpStatus.OK);

	}

	// Update - PUT
	// create, read by id
	@PutMapping("/updateMushroom/{id}")
	public ResponseEntity<Mushrooms> update(@PathVariable Long id, @RequestBody Mushrooms mushroom) {
		return new ResponseEntity<Mushrooms>(this.service.update(id, mushroom), HttpStatus.ACCEPTED);

	}

	// Delete - DELETE
	@DeleteMapping("/removeMushroom/{id}")
	public ResponseEntity<Mushrooms> delete(@PathVariable Long id) {
		if (this.service.delete(id)) {
			return new ResponseEntity<Mushrooms>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<Mushrooms>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		// return (this.service.delete(id) == true) ? new
		// ResponseEntity<Mushrooms>(HttpStatus.NO_CONTENT) :

	}

}
