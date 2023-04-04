package com.cdac.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cdac.entities.ScheduleFlight;

@Repository
public interface ScheduleFlightDao extends JpaRepository<ScheduleFlight,  Integer> {

	//CustomQuery
	
	@Query("SELECT sh FROM ScheduleFlight sh WHERE sh.takeoffDate = :date ")
	List<ScheduleFlight> findByTakeoffDate(@Param("date") Date date );
	
		
	
	
}
