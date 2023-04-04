package com.cdac.service;

import java.util.List;
import java.util.Optional;

import com.cdac.dto.GetRoute;
import com.cdac.entities.Route;

public interface RouteService {

	Route addRoute(Route route);
	
	List<GetRoute> getAllRoute();
	
	Route findById(int id);
	
	int deleteById(int id);
	
Route editRoute(Route route);
	
	
}
