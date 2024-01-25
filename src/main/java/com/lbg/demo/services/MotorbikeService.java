package com.lbg.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lbg.demo.domain.Motorbike;
import com.lbg.demo.repository.Repo;

// Tells Spring this is a Controller
@Service

public class MotorbikeService {

	private Repo repo;

	public MotorbikeService(Repo repo) {
		super();
		this.repo = repo;
	}

	public ResponseEntity<Motorbike> createMotorbike(Motorbike newMotorbike) {
		Motorbike created = this.repo.save(newMotorbike);
		return new ResponseEntity<Motorbike>(created, HttpStatus.CREATED);
	}

	public List<Motorbike> getMotorbikes() {
		return this.repo.findAll();
	}

	public ResponseEntity<Motorbike> getMotorbike(int id) {
		// returns a box that might have a motorbike in it
		Optional<Motorbike> found = this.repo.findById(id);

		if (found.isEmpty()) { // checks if it's found a motorbike
			return new ResponseEntity<Motorbike>(HttpStatus.NOT_FOUND);
		}

		// attempts to pull the contents out of the box
		Motorbike body = found.get();

		return ResponseEntity.ok(body);

	}

	public ResponseEntity<Motorbike> update(int id, Motorbike newMotorbike) {
		// returns a box that might have a motorbike in it
		Optional<Motorbike> found = this.repo.findById(id);

		if (found.isEmpty()) { // checks if it's found a motorbike
			return new ResponseEntity<Motorbike>(HttpStatus.NOT_FOUND);
		}

		// attempts to pull the contents out of the box
		Motorbike existing = found.get();

		if (newMotorbike.getName() != null) {
			existing.setName(newMotorbike.getName());
		}

		if (newMotorbike.getCountry() != null) {
			existing.setCountry(newMotorbike.getCountry());
		}

		Motorbike updated = this.repo.save(existing);

		return ResponseEntity.ok(updated);
	}

	public boolean remove(int id) {
		this.repo.deleteById(id);

		return !this.repo.existsById(id);
	}
}
