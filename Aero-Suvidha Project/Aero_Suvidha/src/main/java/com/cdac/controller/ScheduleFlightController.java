package com.cdac.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cdac.dto.GetScheduleDetails;
import com.cdac.dto.Response;
import com.cdac.dto.ScheduleDetails;
import com.cdac.entities.ScheduleFlight;
import com.cdac.service.ScheduleFlightService;

@CrossOrigin(origins = "*")
@Controller
public class ScheduleFlightController {
   
	@Autowired
	private ScheduleFlightService scheduleflightservice;
	
	
	@PostMapping("/schedule/add")
	public ResponseEntity<?> addFlightInSchedule(@RequestBody GetScheduleDetails sd  )  
	{
        ScheduleFlight sf=scheduleflightservice.addSchedule(sd);
		
		if(sf==null)
		 {
			return Response.error("you did not set the price for that route");
     	 }
		return Response.success("flight schedule sucessfully");		
	}
	
	
	
	
	@GetMapping("/schedule/get")
	public ResponseEntity<?> getFlightInSchedule( )  
	{
	    List<ScheduleDetails> result= scheduleflightservice.getSchedule();
	   // if(result==null)
	    if(result.isEmpty())
	    {
		return Response.error(" not found");
	    }
	    return Response.success(result);		
	 }
	
	@DeleteMapping("/schedule/delete/{id}")
	public ResponseEntity<?> deleteFlight(@PathVariable int id)
	{
		int result=scheduleflightservice.deleteById(id);
		if(result!=1)
		{
			return Response.error("Schedule not found");
		}
		return Response.success(result);
	}
	
	@PutMapping("schedule/modify/{id}")
	public ResponseEntity<?> modifyFlight(@PathVariable("id") int id,@RequestBody GetScheduleDetails getsd)
	{
		ScheduleFlight result=	scheduleflightservice.modifySchedule(getsd,id);
		if(result==null)
		{
			return Response.error("fail to modify schedule");
		}
		return Response.success("modified sucessflly");
	}
	
}
