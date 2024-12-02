package com.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.project.Entities.Country;
import com.project.Exceptions.ResponseStructure;
import com.project.repositories.CountryRepo;
import com.project.repositories.PlaceRepo;

@Repository
public class CountryService {

	@Autowired
	CountryRepo ctr;
	
	@Autowired
	PlaceService ps;
	
	@Autowired
	PlaceRepo pr;
	
	public ResponseEntity<ResponseStructure<Country>> findCountryById(int id){
		ResponseStructure<Country> res = new ResponseStructure<>();
		res.setStatuscode(HttpStatus.OK.value());
		res.setMsg("country fetched successfully");
		res.setData(ctr.findById(id).get());
		return new ResponseEntity<ResponseStructure<Country>>(res,HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<List<Country>>> findAllCountries() {
		System.out.println("fetching country");
		List<Country> list = ctr.findAll();
		System.out.println("countries fetched");
		list.forEach(c -> c.getPlace().forEach(p -> System.out.println(p.getName())));
		ResponseStructure<List<Country>> res = new ResponseStructure<>();
		res.setStatuscode(HttpStatus.OK.value());
		res.setMsg("All countries fetched successfully");
		res.setData(ctr.findAll());
		return new ResponseEntity<ResponseStructure<List<Country>>> (res,HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Country>> saveCountry(Country country) {
		ResponseStructure<Country> res = new ResponseStructure<>();
		res.setStatuscode(HttpStatus.OK.value());
		res.setMsg("Country fetched successfully");
		res.setData(ctr.save(country));
		return new ResponseEntity<ResponseStructure<Country>> (res,HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Country>> deleteCountry(String name) {
		Country c = ctr.findCountryByName(name);
		pr.findPlacesById(c.getId()).forEach(pl->{ pl.setCountry(null);});
		String cname = c.getName();
		ctr.delete(c);
		ResponseStructure<Country> res = new ResponseStructure<>();
		res.setStatuscode(HttpStatus.OK.value());
		res.setMsg("Country " + cname + " deleted successfully");
		res.setData(c);
		return new ResponseEntity<ResponseStructure<Country>> (res,HttpStatus.OK);
	}
}
