package com.cdac.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.dto.Response;
import com.cdac.entities.Flight;
import com.cdac.service.FlightService;
import com.cdac.dto.GetFlight;


@CrossOrigin(origins = "*")
@RestController
public class FlightController {
    @Autowired
	private FlightService flightservice;
	
	@PostMapping("flight/add")
	public ResponseEntity<?> addFlight(@RequestBody Flight f)
	{
		Flight result=flightservice.addFlight(f);
		if(result==null)
		{
			return Response.error("Not Added");
		}
		return Response.success(result);
	}	
	
	@GetMapping("flight/getAll")
	public ResponseEntity<?> getAllFlight()
	{
		ArrayList<GetFlight> result=flightservice.getAllFlightDetails();
		if(result.isEmpty())
		{
			return Response.error("Flight not found");
		}
		return Response.success(result);
		
	}
	
	
	@DeleteMapping("/flight/delete/{id}")
	public ResponseEntity<?> deleteFlight(@PathVariable int id)
	{
		int result=flightservice.deleteById(id);
		if(result!=1)
		{
			return Response.error("flight not found");
		}
		return Response.success(result);
	}
	
	
	
	
	
	
	
	@PutMapping("flight/modify/{id}")
	public ResponseEntity<?> modifyFlight(@PathVariable("id") int id,@RequestBody GetFlight f)
	{
		
	Flight flight= flightservice.findbyId(id);
	
		flight.setAirlineName(f.getAirlineName());
		flight.setCompanyName(f.getCompanyName());
		flight.setEconomyClassSeats(f.getEconomyClassSeats());
		flight.setBuisnessClassSeats(f.getBuisnessClassSeats());
		flight.setFirstClassSeats(f.getFirstClassSeats());
		flight.setCabinBaggageCapacity(f.getCabinBaggageCapacity());
		flight.setCheckinBaggageCapacity(f.getCheckinBaggageCapacity());
	
		Flight result=flightservice.modifyFlight(flight);
		System.out.println("check "+result  );
		if(result==null)
		{
			return Response.error("flight not found");
		}
		return Response.success(result);
	}
	
	
	
}
