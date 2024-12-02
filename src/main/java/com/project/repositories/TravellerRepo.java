package com.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.Entities.Traveller;

public interface TravellerRepo extends JpaRepository<Traveller, Integer>{

	Traveller findByName(String name);

	
}
