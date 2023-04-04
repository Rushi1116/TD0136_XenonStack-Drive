package com.cdac.controller;

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

import com.cdac.dto.PassengerInputDto;
import com.cdac.entities.Passenger;
import com.cdac.service.PassengerService;
import com.cdac.dto.Response;

@CrossOrigin(origins = "*")
@RestController
public class PassengerController {
    @Autowired
    private PassengerService passengerservice ;
	
     @PostMapping("/passenger/info")
     public ResponseEntity<?> addpassengerinfo(@RequestBody PassengerInputDto pdto) 
     {
    	 System.out.println("Passenger details ==" +pdto);
    	 Passenger result= passengerservice.addpassenger(pdto);
    	 if(result==null)
 		{
 			return Response.error("user not found");
 		}
 		return Response.success(result);
     }
	
     @DeleteMapping("/passenger/delete/{id}")
	public ResponseEntity<?>  deletePassenger(@PathVariable int id)
	{
		int result=passengerservice.deleteById(id);
		if(result!=1)
		{
			return Response.error("user not found");
		}
		return Response.success(result);
		
	}
     
    @GetMapping("/passenger/edit/{id}")
 	public ResponseEntity<?> beforeEditPassenger(@PathVariable int id)
 	{
    	Passenger result= passengerservice.findById(id);
    	if(result==null)
		{
			return Response.error("user not found");
		}
		return Response.success(result);
    	 
 	}
//    //update Passenger_M 
    @PutMapping("/passenger/edit/{id}")
    public ResponseEntity<?> afterEditPassenger(@PathVariable("id") int id, @RequestBody Passenger p)
	{
   	 System.out.println("in user signup user :"+p);
		Passenger result=passengerservice.update(id,p);
		if(result==null)
		{
			return Response.error("user not found");
		}
		return Response.success(result);
    	
	}
     
     
     
     
     
     
}
