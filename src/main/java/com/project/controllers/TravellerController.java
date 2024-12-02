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

import com.project.Entities.Traveller;
import com.project.Exceptions.ResponseStructure;
import com.project.services.TravellerService;

@RestController
public class TravellerController {

	@Autowired
	TravellerService ts;
	
	@GetMapping("/traveller/{id}")
	public ResponseEntity<ResponseStructure<Traveller>> getTravellerById(@PathVariable int id){
		return ts.findTravellerById(id);
	}
	
	@GetMapping("/travellers")
	public ResponseEntity<ResponseStructure< List<Traveller>>> findAllTravellers(){
		return ts.findAllTravellers();
	}
	
	@PostMapping("/savetraveller")
	public ResponseEntity<ResponseStructure<Traveller>> saveTraveller(@RequestBody Traveller Traveller) {
		return ts.saveTraveller(Traveller);
	}
	
	@PutMapping("updatetraveller")
	public String updateTraveller(@RequestBody Traveller Traveller) {
		 return "Traveller updated Successfully";
	}
	
	@DeleteMapping("/deletetraveller/{name}")
	public ResponseEntity<ResponseStructure<Traveller>> deleteTraveller(@PathVariable String name) {
		return ts.deleteTraveller(name);
		
	}
}
