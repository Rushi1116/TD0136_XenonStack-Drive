package com.cdac.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdac.dao.PassengerDao;
import com.cdac.dto.DtoEntityConverter;
import com.cdac.dto.PassengerInputDto;
import com.cdac.entities.Passenger;

@Transactional
@Service
public class PassengerServiceImpl  implements PassengerService{
    @Autowired
   private 	PassengerDao passengerdao;
	
	@Autowired
	private DtoEntityConverter convertor ;
	
	@Override
	public Passenger addpassenger(PassengerInputDto pdto) {
		
		System.out.println("passengerdto  "+pdto);
		Passenger p1= convertor.convertToPassengerEntity(pdto);
		System.out.println("Convert to passenger entity "+p1);
		Passenger p2=passengerdao.save(p1);
		System.out.println("after save-->  "+p2);
		
	   return p2;
	}

	@Override
	public int deleteById(int id) {
		try {
		passengerdao.deleteById(id);
		return 1;
		}catch(Exception e) {System.out.println("No Record found");}
		return 0;
	}

	@Override
	public Passenger findById(int id) {
	Optional<Passenger> p1 =passengerdao.findById(id);
      Passenger passenger=p1.orElse(null);
		return passenger;
	}

	
	// //update Passenger_M 
	@Override
	public Passenger update(int id ,Passenger p) {
		try {
		Optional<Passenger> p1=	passengerdao.findById(id);
		if(!p1.isEmpty())
		{

			Passenger passenger=p1.get();
			passenger.setPassengerName(p.getPassengerName());
			passenger.setPassengerDob(p.getPassengerDob());
			passenger.setPassengerAadharNo(p.getPassengerAadharNo());
			passenger.setPassengerpassportNo(p.getPassengerpassportNo());
			passenger.setEmail(p.getEmail());
			passenger.setPhoneNo(p.getPhoneNo());
			Passenger updatedpassenger =passengerdao.save(passenger);
			System.out.println("contine");
			return updatedpassenger;
		}
		}catch(Exception e) {System.out.println("No Record Found");}
		
			return null;
		
		
	}

}
