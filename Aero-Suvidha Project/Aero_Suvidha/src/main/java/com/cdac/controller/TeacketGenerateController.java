package com.cdac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.dto.Response;
import com.cdac.dto.TicketDTO;
import com.cdac.dto.TicketOutDTO;
import com.cdac.service.TicketService;

@CrossOrigin(origins = "*")
@RestController
public class TeacketGenerateController {

	@Autowired
	private TicketService ticketservice;
	
	//change
	@PostMapping("/after/pay")
	public ResponseEntity<?> generateTicketAndInsertBookingInfo(@RequestBody TicketDTO t)
	{
		TicketOutDTO result=ticketservice.generateTicket(t);
		if(result==null)
		{
			return Response.error("user not found");
		}
		return Response.success(result);
	}
}
