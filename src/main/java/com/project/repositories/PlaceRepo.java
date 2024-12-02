package com.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.Entities.Country;
import com.project.Entities.Place;

public interface PlaceRepo extends JpaRepository<Place, Integer>{

	Place findByName(String name);

	Iterable<Place> findPlacesById(int id);

}
