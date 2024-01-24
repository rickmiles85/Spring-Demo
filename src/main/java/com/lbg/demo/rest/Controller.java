package com.lbg.demo.rest;

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

import com.lbg.demo.domain.Motorbike;

@RestController

// Tells Spring this is a Controller

public class Controller {

	// Creates an Array List of Motorbikes

	private List<Motorbike> motorbikes = new ArrayList<>();

	@PostMapping("/create")
	public ResponseEntity<Motorbike> createMotorbike(@RequestBody Motorbike newMotorbike) {
		this.motorbikes.add(newMotorbike);
		// This Returns the last Motorbike in the list
		Motorbike body = this.motorbikes.get(this.motorbikes.size() - 1);
		// return motorbikes.toString();
		return new ResponseEntity<Motorbike>(body, HttpStatus.CREATED);
		// This shows a return Status (200,202,400,405)

	}

// Get ID Page - Using List

	@GetMapping("/get")
	public List<Motorbike> getMotorbikes() {
		return motorbikes;

	}

// 'id' -> index (for now) - Original Text

//	@GetMapping("/get/{id}")
//	public Motorbike getMotorbike(@PathVariable int id) {
//		return this.motorbikes.get(id);
//	}

	// 'id' -> index - New Text with If Statement

	@GetMapping("/get/{id}")
	public ResponseEntity<Motorbike> getMotorike(@PathVariable int id) {
		if (id < 0 || id >= this.motorbikes.size()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		Motorbike found = this.motorbikes.get(id);

		return ResponseEntity.ok(found);
	}

// delete by ID

	@DeleteMapping("/delete/{id}")
	public Motorbike remove(@PathVariable int id) {
		return this.motorbikes.get(id);

	}

// Updating ID

	@PutMapping("/update/{id}")
	public Motorbike update(@PathVariable int id, @RequestBody Motorbike newMotorbike) {
		return this.motorbikes.set(id, newMotorbike);

	}

//status codes

}
