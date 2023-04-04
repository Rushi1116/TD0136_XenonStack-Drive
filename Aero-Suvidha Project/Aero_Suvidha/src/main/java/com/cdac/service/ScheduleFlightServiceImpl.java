package com.cdac.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdac.dao.FlightDao;
import com.cdac.dao.PriceDao;
import com.cdac.dao.RouteDao;
import com.cdac.dao.ScheduleFlightDao;
import com.cdac.dto.GetScheduleDetails;
import com.cdac.dto.ScheduleDetails;
import com.cdac.entities.Flight;
import com.cdac.entities.Price;
import com.cdac.entities.Route;
import com.cdac.entities.ScheduleFlight;


@Transactional
@Service
public class ScheduleFlightServiceImpl implements ScheduleFlightService {
 @Autowired
 private ScheduleFlightDao scheduleflightdao;
 @Autowired
 private PriceDao pricedao;
 @Autowired
 private  FlightDao flightdao;
 @Autowired
 private RouteDao routedao;
	
    @Override
	public ScheduleFlight addSchedule(GetScheduleDetails sd) {
	   
    	SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf1=new SimpleDateFormat("hh:mm");
    	
    	ScheduleFlight s=new ScheduleFlight();
    	
    	List<Price> allPrice =pricedao.findAll();
    	
    	int sd_routeId =sd.getRouteId();
		int sd_flightId=sd.getFlightId();
    	
		for(Price price : allPrice)
		{
			int priceFlightId =price.getFlight().getFlightId();
			System.out.println("aaaaa");
			System.out.println(priceFlightId);
			
			int priceRouteId =price.getRoute().getRouteId();
			System.out.println(priceRouteId);
			if(sd_flightId == priceFlightId);
			{  
				if(sd_routeId == priceRouteId)
				{
     				System.out.println("before find");
					Optional<Flight> addedFlight =flightdao.findById(sd.getFlightId());
					Flight f= addedFlight.orElse(null);
					s.setFlightschedule(f);
					System.out.println("afterr find");
					
					System.out.println("route");
					Optional<Route> r =routedao.findById(sd.getRouteId());
				    Route route=r.orElse(null);
				    System.out.println(route.getDestination());

				    s.setRouteSchedule(route);
				   // System.out.println(route);
				    System.out.println("after route");
			//=======================================================================
				   // s.setScheduleId(11);
					s.setAvailable_businessClass_seat(f.getBuisnessClassSeats());
					System.out.println(s.getAvailable_businessClass_seat());
					s.setAvailable_economyClass_seat(f.getEconomyClassSeats());
					System.out.println(s.getAvailable_economyClass_seat());
					s.setAvailable_firstClass_seat(f.getEconomyClassSeats());
					System.out.println(s.getAvailable_firstClass_seat());
					//======================================================
					Date tdate = null;
					try {
						tdate = sdf.parse(sd.getTakeoffDate());
					  } catch (ParseException e) {
						e.printStackTrace();
					  }
					s.setTakeoffDate(tdate);
						
					Date ldate = null;
					try {
						  ldate = sdf.parse(sd.getLandingDate());
					    } catch (ParseException e) {
						e.printStackTrace();
				    	}
					s.setLandingDate(ldate);
					
					Date tTime=null;
					try {
					 tTime =sdf1.parse(sd.getTakeoffTime());
					} catch (ParseException e) {
						e.printStackTrace();
					}
					s.setTakeoffTime(tTime);
					
					Date lTime=null;
					try {
					 lTime =sdf1.parse(sd.getLandingTime());
					} catch (ParseException e) {
						e.printStackTrace();
					}
					s.setLandingTime(lTime);
					//=========================================
					
					ScheduleFlight sf=scheduleflightdao.save(s);  ///save flight in schedule
					
					return sf;
				}
		}
		
	}
		return null;
    }
 
 
 //==================================================================================================================
 
	
	@Override
	public List<ScheduleDetails> getSchedule() {
	
		   List<ScheduleFlight> schedule=scheduleflightdao.findAll();
	       List<ScheduleDetails> list=new ArrayList<>();
	       
	       for(ScheduleFlight sch:schedule)
	       {
	    	   ScheduleDetails temp=new ScheduleDetails();
	    	   temp.setScheduleId(sch.getScheduleId());
	    	   temp.setAirlineName(sch.getFlightschedule().getAirlineName());
	    	   temp.setSource(sch.getRouteSchedule().getSource());
	    	   temp.setDestination(sch.getRouteSchedule().getDestination());
	    	   temp.setTakeoffDate(sch.getTakeoffDate());
	    	   temp.setLandingDate(sch.getLandingDate());
	    	   temp.setTakeoffTime(sch.getTakeoffTime());
	    	   temp.setLandingTime(sch.getLandingTime());
	    	   
	    	   list.add(temp);
	    	}
	
		return list;
	}



	@Override
	public int deleteById(int id) {
		
		scheduleflightdao.deleteById(id);
		
		return 1;
	}



	
	@Override
	public ScheduleFlight modifySchedule(GetScheduleDetails getsd, int id) {
		
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf1=new SimpleDateFormat("hh:mm");
		
	Optional<ScheduleFlight> op	=scheduleflightdao.findById(id);
	ScheduleFlight schedule=op.orElse(null);
		//ScheduleFlight schedule=scheduleflightdao.getById(id);
		Date takedate = null;
		try {
			takedate = sdf.parse(getsd.getTakeoffDate());
		  } catch (ParseException e) {
			e.printStackTrace();
		  }
		schedule.setTakeoffDate(takedate);
		
		Date landdate = null;
		try {
			landdate = sdf.parse(getsd.getLandingDate());
		  } catch (ParseException e) {
			e.printStackTrace();
		  }
		schedule.setLandingDate(landdate);
		
		
		Date tTime=null;
		try {
		 tTime =sdf1.parse(getsd.getTakeoffTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		schedule.setTakeoffTime(tTime);
		
		
		Date lTime=null;
		try {
		 lTime =sdf1.parse(getsd.getLandingTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		schedule.setLandingTime(lTime);
		
		return scheduleflightdao.save(schedule);
	}



	

}
