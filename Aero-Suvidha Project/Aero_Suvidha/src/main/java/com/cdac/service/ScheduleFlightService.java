package com.cdac.service;

import java.util.List;

import com.cdac.dto.GetScheduleDetails;
import com.cdac.dto.ScheduleDetails;
import com.cdac.entities.ScheduleFlight;

public interface ScheduleFlightService {

	ScheduleFlight addSchedule(GetScheduleDetails sd);
	
	List<ScheduleDetails> getSchedule();
	
	  int  deleteById(int id);
	 
	  ScheduleFlight  modifySchedule(GetScheduleDetails getsd,int id);
}
