package com.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.Entities.Passport;

public interface PassportRepo extends JpaRepository<Passport,Integer>{

	Passport findByPassportNo(String name);

}
