package com.lbg.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lbg.demo.domain.Motorbike;

public interface Repo extends JpaRepository<Motorbike, Integer> {

}
