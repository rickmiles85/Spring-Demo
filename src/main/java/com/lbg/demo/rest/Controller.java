package com.lbg.demo.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lbg.demo.domain.Motorbike;
import com.lbg.demo.services.MotorbikeService;

@RestController

// Tells Spring this is a Controller

public class Controller {

	private MotorbikeService service;

// Creates an Array List of Motorbikes

//	Provides a Constructor to link the Service logic across to theController

	public Controller(MotorbikeService service) {
		super();
		this.service = service;
	}

	@PostMapping("/create")
	public ResponseEntity<Motorbike> createMotorbike(@RequestBody Motorbike newMotorbike) {
		return this.service.createMotorbike(newMotorbike);

	}

// Get ID Page - Using List

	@GetMapping("/get")
	public List<Motorbike> getMotorbikes() {
		return this.service.getMotorbikes();

	}

// 'id' -> index (for now) - Original Text

//	@GetMapping("/get/{id}")
//	public Motorbike getMotorbike(@PathVariable int id) {
//		return this.motorbikes.get(id);
//	}

	// 'id' -> index - New Text with If Statement

	@GetMapping("/get/{id}")
	public ResponseEntity<Motorbike> getMotorike(@PathVariable int id) {
		return this.service.getMotorbike(id);
	}

// delete by ID

	@DeleteMapping("/remove/{id}")
	public boolean remove(@PathVariable int id) {
		return this.service.remove(id);

	}

// Updating ID

	@PutMapping("/update/{id}")
	public ResponseEntity<Motorbike> update(@PathVariable int id, @RequestBody Motorbike newMotorbike) {
		return this.service.update(id, newMotorbike);

	}

//status codes

}
