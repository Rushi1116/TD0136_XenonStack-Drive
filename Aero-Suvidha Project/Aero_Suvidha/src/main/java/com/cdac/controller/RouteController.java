package com.cdac.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.service.RouteService;
import com.cdac.dto.GetRoute;
import com.cdac.dto.Response;
import com.cdac.entities.Route;

@CrossOrigin(origins = "*")
@RestController
public class RouteController {

@Autowired	
private RouteService routeservice ;	
	
@PostMapping("/route/add")
public ResponseEntity<?> addRoute(@RequestBody Route route )
{
	Route result=routeservice.addRoute(route);
	if(result==null)
	{
		return Response.error("Route  not Added");
	}
	return Response.success(result);
}

@GetMapping("/route/getAll")
public ResponseEntity<?> getAllRoute()
{
	List<GetRoute> result=routeservice.getAllRoute();
	if(result.isEmpty())
	//if(result==null)
	{
		return Response.error("Route not found");
	}
	return Response.success(result);
}


@DeleteMapping("/route/delete/{id}")
public ResponseEntity<?> deleteRoute(@PathVariable int id)
{
	System.out.println(" :"+id);
	
	int result=routeservice.deleteById(id);
	if(result!=1)
	{
		return Response.error("route not found");
	}
	return Response.success(result);
}



@PutMapping("route/edit/{id}")
public ResponseEntity<?> modifyRoute(@PathVariable("id") int id , @RequestBody GetRoute getroute )
{
	
	System.out.println("Route id is id  "+id );
	Route route=routeservice.findById(id);

	route.setSource(getroute.getSource());
	route.setDestination(getroute.getDestination());
	
	Route result=routeservice.editRoute(route);
if(result==null)
{
	return Response.error(" fail to edit route");
}
return Response.success(result);




}



}
