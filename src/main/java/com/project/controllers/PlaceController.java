package com.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.Entities.Place;
import com.project.Exceptions.ResponseStructure;
import com.project.services.PlaceService;

@RestController
public class PlaceController {

	@Autowired
	PlaceService ps;
	
	@GetMapping("/place/{id}")
	public ResponseEntity<ResponseStructure<Place>> getPlaceById(@PathVariable int id){
		return ps.findPlaceById(id);
	}
	
	@GetMapping("/places")
	public ResponseEntity<ResponseStructure< List<Place>>> findAllPlaces(){
		return ps.findAllPlaces();
	}
	
	@PostMapping("/saveplace")
	public ResponseEntity<ResponseStructure<Place>> savePlace(@RequestBody Place Place) {
		return ps.savePlace(Place);
	}
	
	@PutMapping("updateplace")
	public String updatePlace(@RequestBody Place Place) {
		 ps.savePlace(Place);
		 return "Place updated Successfully";
	}
	
	@DeleteMapping("/deleteplace/{name}")
	public ResponseEntity<ResponseStructure<Place>> deletePlace(@PathVariable String name) {
	
		return ps.deletePlace(name);
		
	}
}
