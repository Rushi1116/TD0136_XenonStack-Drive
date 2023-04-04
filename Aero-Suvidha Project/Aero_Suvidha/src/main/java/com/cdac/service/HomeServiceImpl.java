package com.cdac.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdac.dao.PriceDao;
import com.cdac.dao.ScheduleFlightDao;
import com.cdac.dto.SearchFlight;
import com.cdac.dto.SearchFlightDto;
import com.cdac.entities.Price;
import com.cdac.entities.ScheduleFlight;

@Transactional
@Service
public class HomeServiceImpl implements HomeService{

	@Autowired
	private ScheduleFlightDao scheduleflightdao;
	@Autowired
	private PriceDao pricedao;
	
	
	
	@Override
	public List<SearchFlightDto> searchFlight(SearchFlight searchinfo) {
		
		 String d1=searchinfo.getDate();
		 SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
		 SimpleDateFormat sdf1=new SimpleDateFormat("hh:mm:ss");
		 
		 Date date=null;
		 try {
			 date=sdf.parse(d1);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		 System.out.println("control in dao");
		 
		ArrayList<SearchFlightDto> flightdto =new ArrayList<SearchFlightDto>();
	    List<ScheduleFlight> scheduleflight=null;
	    scheduleflight= scheduleflightdao.findByTakeoffDate(date);
	                        
	    if(scheduleflight==null)
	    {
	    	return null;
	    }
	    else
	    {
	         for(ScheduleFlight sf:scheduleflight)
	         {            System.out.println("INSIDE LOOP");
	        	 if(sf.getRouteSchedule().getSource().equals(searchinfo.getSource()));//Source Compare
	        	 {                        System.out.println("Source");
	        	// System.out.println(sf.getRouteSchedule().getDestination() +" sf");
	        	 //System.out.println(searchinfo.getDestination()+" searchinfo ");
	        		   if(sf.getRouteSchedule().getDestination().equals(searchinfo.getDestination())) //Destination Compare
	        		   {
	        			   System.out.println("Destination");
	        			  
	        			   SearchFlightDto serchFlightDto=new SearchFlightDto();
	        			   serchFlightDto.setSheduleId(sf.getScheduleId());
	        			   serchFlightDto.setSource(sf.getRouteSchedule().getSource());
	        			   serchFlightDto.setDestination(sf.getRouteSchedule().getDestination());
	        			   String takeoffdate=sdf.format(sf.getTakeoffDate());
	        			   serchFlightDto.setTakeoffDate(takeoffdate);
	        			   String landingdate=sdf.format(sf.getLandingDate());
	        			   serchFlightDto.setLandingDate(landingdate);
	        			   serchFlightDto.setCompanyName(sf.getFlightschedule().getAirlineName());
	        			   String takeofftime=sdf1.format(sf.getTakeoffTime());
	        			   serchFlightDto.setTakeoffTime(takeofftime);
	        			   String landingtime=sdf1.format(sf.getLandingTime());
	        			   serchFlightDto.setLandingTime(landingtime);
	        			   System.out.println("Setter Done");
	        			   //==========================================================
	        			          //set price and and availableSeat onBasis of classType
	        			   //==========================================================
	        			     List<Price> allPrice=pricedao.findAll();
	        			     for(Price price : allPrice)
	        			     {
	        			    	// System.out.println(price.getFlight().getFlightId()+ "price ");
	        			    	 //System.out.println(sf.getFlightschedule().getFlightId() +"ScheduleFlight sf ");
	        			    	 if(price.getFlight().getFlightId()==sf.getFlightschedule().getFlightId())
	        			    	 {
	        			    		
	        			    		 if(price.getRoute().getRouteId()==sf.getRouteSchedule().getRouteId())
	        			    		 {
	        			    			
	        			    			 System.out.println("all check");
	        			    			 if(searchinfo.getClassType().equals("economy"))
	        			    			 {
	        			    				 serchFlightDto.setPrice(price.getEconomyClassPrice());
	        			    				 serchFlightDto.setAvalable_Seat(sf.getAvailable_economyClass_seat());
	        			    			 }
	        			    			 if(searchinfo.getClassType().equals("business"))
	   							         {
	        			    				 serchFlightDto.setPrice(price.getBusinessClassPrice()); 
	        			    				 serchFlightDto.setAvalable_Seat(sf.getAvailable_businessClass_seat());
	   							         }
	        			    			 if(searchinfo.getClassType().equals("first"))
	   						      	     {
	        			    				 serchFlightDto.setPrice(price.getFirstClassPrice());
	        			    				 serchFlightDto.setAvalable_Seat(sf.getAvailable_firstClass_seat());
	   						      	     }
	        			    			 
	        			    		 }
	        			    	 }
	        			     }
	        			//===========================================//adding searchflightdto in list
	        			     if(serchFlightDto !=null)
	        			     {
	        			    	 flightdto.add(serchFlightDto) ;
	        			     }
	        			   System.out.println("After Add");
	        		   }
	        	 }
	        	
	         }
	    	
	    	
	    }	
		
		
		 
		return flightdto;
	}

}
// sf.getRouteSchedule().getSource().equalsIgnoreCase(searchinfo.getSource()); for compare source