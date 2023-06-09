package com.cdac.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdac.entities.Bookings;

@Repository
public interface BookingDao extends JpaRepository<Bookings, Integer>{

}
