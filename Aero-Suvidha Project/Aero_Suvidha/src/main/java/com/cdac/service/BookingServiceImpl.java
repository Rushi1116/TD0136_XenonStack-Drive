package com.cdac.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdac.dao.BookingDao;
import com.cdac.dao.UserDao;
import com.cdac.dto.BookingConverter;
import com.cdac.dto.BookingHistoryDto;
import com.cdac.entities.Bookings;
import com.cdac.entities.User;

@Transactional
@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	private BookingDao bookingdao;
	
	@Autowired
	private UserDao userdao;
	
	@Autowired
	private BookingConverter bookingconvertor;
	
	@Override
	public ArrayList<BookingHistoryDto> showUpcomingBooking(int id) {
	   
		ArrayList<Bookings> bookingFlightList= new ArrayList<Bookings>();
		ArrayList<BookingHistoryDto> bookingListDto= new ArrayList<BookingHistoryDto>();
	    
		Optional<User> u=userdao.findById(id);
	    User user=u.orElse(null);
		
        List<Bookings>bookingList= bookingdao.findAll();	
        
    
        for(Bookings book:bookingList)
       {
    	  Date date1=book.getScheduleFlight().getTakeoffDate();
    	  //currentDate
    	  Date date=new Date();
    	
    	  if(user.getUserId()==book.getUser().getUserId())
    	   {
    		if(date1.after(date))
    		{
    			bookingFlightList.add(book);
    		}
    		
    	   }
    	
       }
        bookingListDto=  bookingconvertor.sendBookingHistory(bookingFlightList);
    
		return bookingListDto;
	}
	

	@Override
	public ArrayList<BookingHistoryDto> showCompletedBooking(int id) {
		
		 List<Bookings> bookingList= null;
		 ArrayList<BookingHistoryDto> bookingListDto= new ArrayList<BookingHistoryDto>();
		 ArrayList<Bookings> bookingFlightList= new ArrayList<Bookings>();
		
		 bookingList= bookingdao.findAll();	
		 
		 for(Bookings bookings : bookingList)
		 {
			 Date date1=bookings.getScheduleFlight().getTakeoffDate();
			 Date date=new Date();
			 if(date1.before(date))
			 {
				 bookingFlightList.add(bookings); 
			 }
			 
		  }
		 bookingListDto  = bookingconvertor.sendBookingHistory(bookingFlightList);
		 return bookingListDto;      
		}


	@Override
	public ArrayList<BookingHistoryDto> showCancelledBooking(int id) {
		
		 List<Bookings> bookingList= null;
		 ArrayList<BookingHistoryDto> bookingListDto= new ArrayList<BookingHistoryDto>();
		 ArrayList<Bookings> bookingFlightList= new ArrayList<Bookings>();
		  
		    Optional<User> u= userdao.findById(id);
		    User user=u.orElse(null);
		    
		    bookingList=    bookingdao.findAll();
		    
		    for(Bookings bookings : bookingList)
		    {
		    	if(user.getUserId()==bookings.getUser().getUserId())
		    	{
		    		if(bookings.getBookingStatus().equals("cancelled"))
		    		{
		    			bookingFlightList.add(bookings);
		    		}
		    	}
		    	
		     }
		    bookingListDto=bookingconvertor.sendBookingHistory(bookingFlightList);
		    return bookingListDto;
	}


	@Override
	public Bookings updateBookingStatusOnCancelling(int id) {
		
		    Optional<Bookings> book =bookingdao.findById(id);
		    Bookings booking=book.orElse(null);
		    booking.setBookingStatus("cancelled");
		    Bookings   updatedbooking=bookingdao.save(booking);
		    return updatedbooking;
	}
	
	
	
	
}
