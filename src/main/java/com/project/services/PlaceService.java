package com.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.project.Entities.Place;
import com.project.Exceptions.ResponseStructure;
import com.project.repositories.PlaceRepo;

@Repository
public class PlaceService {

	@Autowired
	PlaceRepo pr;
	
	public ResponseEntity<ResponseStructure<Place>> findPlaceById(int id){
		ResponseStructure<Place> res = new ResponseStructure<>();
		res.setStatuscode(HttpStatus.OK.value());
		res.setMsg("Place fetched successfully");
		res.setData(pr.findById(id).get());
		return new ResponseEntity<ResponseStructure<Place>>(res,HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<List<Place>>> findAllPlaces() {
		ResponseStructure<List<Place>> res = new ResponseStructure<>();
		res.setStatuscode(HttpStatus.OK.value());
		res.setMsg("All Places fetched successfully");
		res.setData(pr.findAll());
		return new ResponseEntity<ResponseStructure<List<Place>>> (res,HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Place>> savePlace(Place place) {
		System.out.println(place.getId());
		System.out.println(place.getName());
		System.out.println(place.getDescription());
		System.out.println(place.getRating());
		System.out.println(place.getCountry());
		ResponseStructure<Place> res = new ResponseStructure<>();
		res.setStatuscode(HttpStatus.OK.value());
		res.setMsg("Place "+place.getName()+" saved successfully");
		res.setData(pr.save(place));
		return new ResponseEntity<ResponseStructure<Place>> (res,HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Place>> deletePlace(String name) {
		Place c = pr.findByName(name);
		String cname = c.getName();
		pr.delete(c);
		ResponseStructure<Place> res = new ResponseStructure<>();
		res.setStatuscode(HttpStatus.OK.value());
		res.setMsg("Place " + cname + " deleted successfully");
		res.setData(c);
		return new ResponseEntity<ResponseStructure<Place>> (res,HttpStatus.OK);
	}
}
