package com.Thymeleaf.thymeleaf.service;

import java.util.List;

import com.Thymeleaf.thymeleaf.Entity.Passenger;

public interface PassengerService {

	public List<Passenger> findAll();
	
	public Passenger findById(int theId);
	
	public void save(Passenger thePassenger);
	
	public void deleteById(int theId);
	
}