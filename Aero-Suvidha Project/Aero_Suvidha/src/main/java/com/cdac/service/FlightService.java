package com.cdac.service;

import java.util.ArrayList;
import java.util.Optional;

import com.cdac.dto.GetFlight;
import com.cdac.entities.Flight;

public interface FlightService {

	
 Flight	addFlight(Flight f);
   
 ArrayList<GetFlight>  getAllFlightDetails();	

 Flight findbyId(int id);
 
   int deleteById(int id);

 Flight modifyFlight(Flight flight) ;
 
 
 

  
}
