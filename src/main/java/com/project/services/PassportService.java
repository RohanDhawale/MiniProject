package com.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.Entities.Passport;
import com.project.Exceptions.ResponseStructure;
import com.project.repositories.PassportRepo;

@Service
public class PassportService {

	@Autowired
	PassportRepo pr;
	
	public ResponseEntity<ResponseStructure<Passport>> findPassportById(int id){
		ResponseStructure<Passport> res = new ResponseStructure<>();
		res.setStatuscode(HttpStatus.OK.value());
		res.setMsg("Passport fetched successfully");
		res.setData(pr.findById(id).get());
		return new ResponseEntity<ResponseStructure<Passport>>(res,HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<List<Passport>>> findAllPassports() {
		ResponseStructure<List<Passport>> res = new ResponseStructure<>();
		res.setStatuscode(HttpStatus.OK.value());
		res.setMsg("All Passports fetched successfully");
		res.setData(pr.findAll());
		return new ResponseEntity<ResponseStructure<List<Passport>>> (res,HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Passport>> savePassport(Passport Passport) {
		ResponseStructure<Passport> res = new ResponseStructure<>();
		res.setStatuscode(HttpStatus.OK.value());
		res.setMsg("Passport fetched successfully");
		res.setData(pr.save(Passport));
		return new ResponseEntity<ResponseStructure<Passport>> (res,HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Passport>> deletePassport(String name) {
		Passport c = pr.findByPassportNo(name);
		String cname = c.getPassportNo();
		pr.delete(c);
		ResponseStructure<Passport> res = new ResponseStructure<>();
		res.setStatuscode(HttpStatus.OK.value());
		res.setMsg("Passport " + cname + " deleted successfully");
		res.setData(c);
		return new ResponseEntity<ResponseStructure<Passport>> (res,HttpStatus.OK);
	}
}
