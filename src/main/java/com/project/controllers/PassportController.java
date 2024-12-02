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

import com.project.Entities.Passport;
import com.project.Exceptions.ResponseStructure;
import com.project.services.PassportService;

@RestController
public class PassportController {

	@Autowired
	PassportService ps;
	
	@GetMapping("/passport/{id}")
	public ResponseEntity<ResponseStructure<Passport>> getPassportById(@PathVariable int id){
		return ps.findPassportById(id);
	}
	
	@GetMapping("/passports")
	public ResponseEntity<ResponseStructure< List<Passport>>> findAllPassport(){
		return ps.findAllPassports();
	}
	
	@PostMapping("/savePassport")
	public ResponseEntity<ResponseStructure<Passport>> savePassport(@RequestBody Passport Passport) {
		return ps.savePassport(Passport);
	}
	
	@PutMapping("updatePassport")
	public String updatePassport(@RequestBody Passport Passport) {
		 ps.savePassport(Passport);
		 return "Passport updated Successfully";
	}
	
	@DeleteMapping("/deletePassport/{name}")
	public ResponseEntity<ResponseStructure<Passport>> deletePassport(@PathVariable String name) {
		return ps.deletePassport(name);
		
	}
}
