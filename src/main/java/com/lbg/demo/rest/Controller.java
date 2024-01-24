package com.lbg.demo.rest;

import java.util.ArrayList;
import java.util.List;

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
	public String createMotorbike(@RequestBody Motorbike newMotorbike) {
		this.motorbikes.add(newMotorbike);
		return motorbikes.toString();

		// This Returns the last Motorbike in the list
		// return.this.motorbikes.get(this.motorbikes.size() -1);

	}

// Get ID Page - Using List

	@GetMapping("/get")
	public List<Motorbike> getMotorbikes() {
		return motorbikes;

	}

// 'id' -> index (for now)

	@GetMapping("/get{id}")
	public Motorbike getMotorbike(@PathVariable int id) {
		return this.motorbikes.get(id);
	}

// delete by ID

	@DeleteMapping("/delete{id}")
	public Motorbike remove(@PathVariable int id) {
		return this.motorbikes.get(id);

	}

// Updating ID

	@PutMapping("/update/{id}")
	public Motorbike update(@PathVariable int id, @RequestBody Motorbike newMotorbike) {
		return this.motorbikes.set(id, newMotorbike);

	}

}
