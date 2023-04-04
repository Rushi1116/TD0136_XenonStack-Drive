package com.cdac.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cdac.dao.FlightDao;
import com.cdac.dao.PriceDao;
import com.cdac.dao.ScheduleFlightDao;
import com.cdac.dto.GetFlight;
import com.cdac.entities.Flight;

@Transactional
@Service
public class FlightServiceImpl implements FlightService {
     @Autowired
	private FlightDao flightdao;
     @Autowired
     private PriceDao pricedao;
     
     @Autowired
     private ScheduleFlightDao scheduleflightdao;
     
     
     
	@Override
	public Flight addFlight(Flight f) {
	
		Flight addedflight=flightdao.save(f);
	    return addedflight;
	}

	
	
	@Override
	public ArrayList<GetFlight> getAllFlightDetails() {
	
		List<Flight> flightlist =flightdao.findAll();
		
		ArrayList<GetFlight> list= new  ArrayList<GetFlight>();
		
		for(Flight f:flightlist)
		{
			GetFlight temp=new GetFlight();
			temp.setFlightId(f.getFlightId());
			temp.setAirlineName(f.getAirlineName());
			temp.setCompanyName(f.getCompanyName());
			temp.setEconomyClassSeats(f.getEconomyClassSeats());
			temp.setBuisnessClassSeats(f.getBuisnessClassSeats());
			temp.setFirstClassSeats(f.getFirstClassSeats());
			temp.setCheckinBaggageCapacity(f.getCheckinBaggageCapacity());
			temp.setCabinBaggageCapacity(f.getCabinBaggageCapacity());
			
			list.add(temp);
		}
		return list;
	}



	@Override
	public Flight findbyId(int id) {
		Optional<Flight> flight =flightdao.findById(id);
		Flight f= flight.orElse(null);
		
		return f;
		}



	@Override
	public Flight modifyFlight(Flight flight) {
		
		return flightdao.save(flight);
	}



	@Override
	public int deleteById(int id) {
		
		Flight flight=findbyId(id);
		if(flight!=null)
		{
		pricedao.deleteAllInBatch(flight.getPriceList());
		scheduleflightdao.deleteAllInBatch(flight.getScheduleFlight());
		flightdao.delete(flight);
		return 1;
		}
		return 0;
	}
	
}
