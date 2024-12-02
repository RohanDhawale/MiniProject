package com.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.Entities.Traveller;
import com.project.Exceptions.ResponseStructure;
import com.project.repositories.TravellerRepo;

@Service
public class TravellerService {

	@Autowired
	TravellerRepo tr;
	
	public ResponseEntity<ResponseStructure<Traveller>> findTravellerById(int id){
		ResponseStructure<Traveller> res = new ResponseStructure<>();
		res.setStatuscode(HttpStatus.OK.value());
		res.setMsg("Traveller fetched successfully");
		res.setData(tr.findById(id).get());
		return new ResponseEntity<ResponseStructure<Traveller>>(res,HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<List<Traveller>>> findAllTravellers() {
		ResponseStructure<List<Traveller>> res = new ResponseStructure<>();
		res.setStatuscode(HttpStatus.OK.value());
		res.setMsg("All Travellers fetched successfully");
		res.setData(tr.findAll());
		return new ResponseEntity<ResponseStructure<List<Traveller>>> (res,HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Traveller>> saveTraveller(Traveller Traveller) {
		ResponseStructure<Traveller> res = new ResponseStructure<>();
		res.setStatuscode(HttpStatus.OK.value());
		res.setMsg("Traveller fetched successfully");
		res.setData(tr.save(Traveller));
		return new ResponseEntity<ResponseStructure<Traveller>> (res,HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Traveller>> deleteTraveller(String name) {
		Traveller c = tr.findByName(name);
		String cname = c.getName();
		tr.delete(c);
		ResponseStructure<Traveller> res = new ResponseStructure<>();
		res.setStatuscode(HttpStatus.OK.value());
		res.setMsg("Traveller " + cname + " deleted successfully");
		res.setData(c);
		return new ResponseEntity<ResponseStructure<Traveller>> (res,HttpStatus.OK);
	}
}
