package com.cdac.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdac.entities.Flight;

@Repository
public interface FlightDao extends JpaRepository<Flight, Integer> {

}
