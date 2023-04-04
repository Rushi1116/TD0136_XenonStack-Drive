package com.cdac.service;


import com.cdac.dto.PassengerInputDto;
import com.cdac.entities.Passenger;

public interface PassengerService {

	
	public Passenger addpassenger(PassengerInputDto pdto);
	
	 public int  deleteById(int id);
	 
	 public Passenger  findById(int id);
	 
 //update Passenger_M 
	 public Passenger update(int i ,Passenger p);
}
