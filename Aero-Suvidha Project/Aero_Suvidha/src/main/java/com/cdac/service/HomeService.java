package com.cdac.service;

import java.util.List;

import com.cdac.dto.SearchFlight;
import com.cdac.dto.SearchFlightDto;

public interface HomeService {

	
List<SearchFlightDto> searchFlight(SearchFlight searchinfo);
}
