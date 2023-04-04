package com.cdac.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cdac.entities.Passenger;

@Repository
public interface PassengerDao extends JpaRepository<Passenger, Integer>{

}
