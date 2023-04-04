package com.cdac.service;

import java.util.ArrayList;

import com.cdac.dto.BookingHistoryDto;
import com.cdac.entities.Bookings;


public interface BookingService {

	
	ArrayList<BookingHistoryDto> showUpcomingBooking(int id);
	
	ArrayList<BookingHistoryDto> showCompletedBooking(int id);
	
	ArrayList<BookingHistoryDto> showCancelledBooking(int id);
	
	
    Bookings updateBookingStatusOnCancelling(int id);
}
