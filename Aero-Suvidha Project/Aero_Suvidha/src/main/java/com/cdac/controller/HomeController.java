package com.cdac.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.dto.Response;
import com.cdac.dto.SearchFlight;
import com.cdac.dto.SearchFlightDto;
import com.cdac.service.HomeService;


@CrossOrigin(origins = "*")
@RestController
public class HomeController {
    @Autowired
	private HomeService homeservice;
	
	
	//changeDone
	@PostMapping("/searchFlight")
	public ResponseEntity<?> serchFlight(@RequestBody SearchFlight searchinfo )
	{
		List<SearchFlightDto> result=homeservice.searchFlight(searchinfo) ; 
		System.out.println("after Controller");
		if(result.isEmpty())
		//if(result==null)
		{
			return Response.error("Flight not found");
		}
		return Response.success(result);
	}
	
	
	
	
}
