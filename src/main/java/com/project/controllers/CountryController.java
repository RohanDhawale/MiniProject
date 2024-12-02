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

import com.project.Entities.Country;
import com.project.Exceptions.ResponseStructure;
import com.project.services.CountryService;

@RestController
public class CountryController {

	@Autowired
	CountryService ctrs;
	
	@GetMapping("/country/{id}")
	public ResponseEntity<ResponseStructure<Country>> getCountryById(@PathVariable int id){
		return ctrs.findCountryById(id);
	}
	
	@GetMapping("/countries")
	public ResponseEntity<ResponseStructure< List<Country>>> findAllCoutunries(){
		return ctrs.findAllCountries();
	}
	
	@PostMapping("/savecountry")
	public ResponseEntity<ResponseStructure<Country>> saveCountry(@RequestBody Country country) {
		return ctrs.saveCountry(country);
	}
	
	@PutMapping("/updatecountry")
	public String updateCountry(@RequestBody Country Country) {
		 ctrs.saveCountry(Country);
		 return "Country updated Successfully";
	}
	
	@DeleteMapping("/deletecountry/{name}")
	public ResponseEntity<ResponseStructure<Country>> deleteCountry(@PathVariable String name) {
		return ctrs.deleteCountry(name);
	}
	
	@PutMapping("/updatecountrysdsdsdsdsd")
	public String updateCountrsdy(@RequestBody Country Country) {
		 ctrs.saveCountry(Country);
		 return "Country updated Successfully";
	}
}
