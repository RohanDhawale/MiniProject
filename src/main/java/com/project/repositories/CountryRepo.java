package com.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.Entities.Country;

public interface CountryRepo extends JpaRepository<Country, Integer>{

	public Country findByName(String name);

	public Country findCountryByName(String name);
}
