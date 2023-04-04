package com.cdac.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.dao.PriceDao;
import com.cdac.dao.RouteDao;
import com.cdac.dao.ScheduleFlightDao;
import com.cdac.dto.GetRoute;
import com.cdac.entities.Route;

@Transactional
@Service
public class RouteServiceImpl implements RouteService {

	@Autowired
	 RouteDao routedao;
	@Autowired
	 ScheduleFlightDao scheduleflightdao;
	
	@Autowired
	 PriceDao pricedao;

	@Override
	public Route addRoute(Route route) {
	   Route result=routedao.save(route);
	   return result;
	}

	@Override
	public List<GetRoute> getAllRoute() {
		
	     List<Route> route=	routedao.findAll();
		 List<GetRoute> getroute=new ArrayList<>();
	     
		 for(Route r:route)
		 {
			 GetRoute temp=new GetRoute();
			 {
				 temp.setRouteId(r.getRouteId());
				 temp.setDestination(r.getDestination());
				 temp.setSource(r.getSource());
			 }
			 getroute.add(temp);
			 
		 }
		 
	     return getroute;
	}

	@Override
	public Route findById(int id) {
	Optional<Route> route=routedao.findById(id);
		Route r=route.orElse(null);
		return r;
	}
	
	
	@Override
	public int deleteById(int id) {
		Route route=findById(id);
		if(route!=null)
		{
		pricedao.deleteAllInBatch(route.getPriceList());
		scheduleflightdao.deleteAllInBatch(route.getScheduleFlight());
		routedao.deleteById(id);
		return 1;
		}
		return 0;
	}

	@Override
	public Route editRoute(Route route) {
		Route result=routedao.save(route);
		   return result;
		}

	
}
