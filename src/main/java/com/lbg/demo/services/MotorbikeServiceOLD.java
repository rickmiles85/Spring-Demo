package com.lbg.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lbg.demo.domain.Motorbike;
import com.lbg.demo.repository.Repo;

// Tells Spring this is a Controller
@Service

public class MotorbikeServiceOLD {

	private Repo repo;

	// Creates an Array List of Motorbikes

	public MotorbikeServiceOLD(Repo repo) {
	super();
	this.repo = repo;
	}

	private List<Motorbike> motorbikes = new ArrayList<>();

	public ResponseEntity<Motorbike> createMotorbike(Motorbike newMotorbike) {
		this.motorbikes.add(newMotorbike);
		// This Returns the last Motorbike in the list
		Motorbike body = this.motorbikes.get(this.motorbikes.size() - 1);
		// return motorbikes.toString();
		return new ResponseEntity<Motorbike>(body, HttpStatus.CREATED);
		// This shows a return Status (200,202,400,405)

	}

// Get ID Page - Using List

	public List<Motorbike> getMotorbikes() {
		return motorbikes;

	}

// 'id' -> index (for now) - Original Text

//	@GetMapping("/get/{id}")
//	public Motorbike getMotorbike(@PathVariable int id) {
//		return this.motorbikes.get(id);
//	}

	// 'id' -> index - New Text with If Statement

	public ResponseEntity<Motorbike> getMotorike(int id) {
		if (id < 0 || id >= this.motorbikes.size()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		Motorbike found = this.motorbikes.get(id);

		return ResponseEntity.ok(found);
	}

// delete by ID

	public Motorbike remove(int id) {
		return this.motorbikes.get(id);

	}

// Updating ID

	public Motorbike update(int id, Motorbike newMotorbike) {
		return this.motorbikes.set(id, newMotorbike);

	}

//status codes

}
