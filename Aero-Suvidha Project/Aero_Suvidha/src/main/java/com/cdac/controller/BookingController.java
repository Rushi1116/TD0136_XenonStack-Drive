package com.cdac.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.dto.BookingHistoryDto;
import com.cdac.dto.Response;
import com.cdac.entities.Bookings;
import com.cdac.service.BookingService;

@CrossOrigin(origins ="*")
@RestController
public class BookingController {

	@Autowired
	private BookingService bookingservice ;
	
	
	@PostMapping("/bookings/upcoming/{id}")
	public ResponseEntity<?> UpcomingBookings(@PathVariable int id)
	{
		ArrayList<BookingHistoryDto> bookingDto=bookingservice.showUpcomingBooking(id);
		System.out.println(bookingDto);
		if(bookingDto.isEmpty())
		//if(bookingDto==null)
		{
			return Response.error("No Upcoming Bookings");
		}
		return Response.success(bookingDto);
	}
	
	//check id--No use
	@PostMapping("/bookings/completed/{id}")
	public ResponseEntity<?> completedBookings(@PathVariable int id)
	{
		ArrayList<BookingHistoryDto> bookingDto =	bookingservice.showCompletedBooking(id);
		if(bookingDto.isEmpty())
		//if(bookingDto==null)
		{
			return Response.error("No Completed Bookings");
		}
		return Response.success(bookingDto);
	}
	
	@PostMapping("/bookings/cancelled/{id}")
	public ResponseEntity<?> showCancelledBookings(@PathVariable int id)
	{
		ArrayList<BookingHistoryDto> bookingDto=bookingservice.showCancelledBooking(id);
		if(bookingDto.isEmpty())
		//if(bookingDto==null)
		{
			return Response.error("No Cancelled Bookings");
		}
		return Response.success(bookingDto);
	}
	
	@PutMapping("/bookings/cancel/{id}")
	public ResponseEntity<?> cancelBookings(@PathVariable int id)
	{
		//id=bookingNo--PK(bookings)
		Bookings result= bookingservice.updateBookingStatusOnCancelling(id);
		if(result==null)
		{
			return Response.error("No Upcoming Bookings");
		}
		return Response.success("Cancelled");
	}
	
	
	
}
