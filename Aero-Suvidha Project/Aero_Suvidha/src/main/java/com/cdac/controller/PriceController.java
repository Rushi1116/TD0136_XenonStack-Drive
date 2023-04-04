package com.cdac.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.service.FlightService;
import com.cdac.service.PriceService;
import com.cdac.service.RouteService;
import com.cdac.dto.GetPrice;
import com.cdac.dto.PriceDetails;
import com.cdac.dto.PriceModify;
import com.cdac.dto.Response;
import com.cdac.entities.Price;

@CrossOrigin(origins = "*")
@RestController
public class PriceController {
    @Autowired
	private PriceService priceservice;
    @Autowired
	FlightService flightService;
	@Autowired
	RouteService routeService;

    
    @PostMapping("price/add")
	public ResponseEntity<?> addPrice(@RequestBody GetPrice p)
	{
       System.out.println("dto getprice  "+p);
      
       Price price=new Price();
       {
       price.setFlight(flightService.findbyId(p.getFlightId()));
       price.setRoute(routeService.findById(p.getRouteId()));
       price.setFirstClassPrice(p.getFirstClassPrice());
       price.setBusinessClassPrice(p.getBusinessClassPrice());
       price.setEconomyClassPrice(p.getEconomyClassPrice());
       }
      
      Price result=priceservice.addprice(price);
      if(result==null)
		{
			return Response.error("fail to add price");
		}
		return Response.success("route added");
    	
	}
    
    @GetMapping("price/getAll")
	public ResponseEntity<?> getPriceList()
	{
	List<PriceDetails> pricelist= priceservice.getPriceList();
	if(pricelist.isEmpty())
	//if(pricelist==null)
	{
		return Response.error("fail to get price");
	}
	return Response.success(pricelist);
    }
    
    @GetMapping("price/get/{id}")
	public ResponseEntity<?> getPrice(@PathVariable int id)
	{
    	PriceDetails price=priceservice.getPrice(id);
    	if(price==null)
		{
			return Response.error("fail to get price");
		}
		return Response.success(price);
    	
	}
    @PutMapping("price/edit/{id}")
	public ResponseEntity<?> modifyPrice(@PathVariable("id") int id,@RequestBody PriceModify pricemodify)
	{
    	Price result=  	priceservice.editPrice(pricemodify,id);
    	if(result==null)
		{
			return Response.error("fail to modify schedule");
		}
		return Response.success("modified sucessflly");
    	
	}
    
	
}
