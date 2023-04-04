package com.cdac.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.dao.PriceDao;
import com.cdac.dto.PriceDetails;
import com.cdac.dto.PriceModify;
import com.cdac.entities.Price;

@Transactional
@Service
public class PriceServiceImpl implements PriceService{
    @Autowired
	private PriceDao pricedao;
	
	@Override
	public Price addprice(Price price) {
		
		return pricedao.save(price) ;
	}

	@Override
	public List<PriceDetails> getPriceList() {
		
 List<Price> pricelist= pricedao.findAll();
 List<PriceDetails> updatedlist=new ArrayList<>();	
 
 for(Price p:pricelist)
 {
	 PriceDetails pd=new PriceDetails();
	 pd.setPriceId(p.getPriceId());
	 pd.setAirlineName(p.getFlight().getAirlineName());
	 pd.setSource(p.getRoute().getSource());
	 pd.setDestination(p.getRoute().getDestination());
	 pd.setBusinessClassPrice(p.getBusinessClassPrice());
	 pd.setEconomyClassPrice(p.getEconomyClassPrice());
	 pd.setFirstClassPrice(p.getFirstClassPrice());
	 updatedlist.add(pd);
 }
 
		return updatedlist;
	}

	@Override
	public PriceDetails getPrice(int id) {
		
	Optional<Price> price=	pricedao.findById(id);
         Price p2=	price.orElse(null);
         PriceDetails temp=new PriceDetails();
         {
        	 temp.setAirlineName(p2.getFlight().getAirlineName());
        	 temp.setSource(p2.getRoute().getSource());
        	 temp.setDestination(p2.getRoute().getDestination());
        	 temp.setBusinessClassPrice(p2.getBusinessClassPrice());
        	 temp.setEconomyClassPrice(p2.getEconomyClassPrice());
        	 temp.setFirstClassPrice(p2.getFirstClassPrice());
        	 
         }
		return temp;
	}

	@Override
	public Price editPrice(PriceModify pricemodify, int id) {
		Optional <Price> price=pricedao.findById(id);
		Price p2=price.orElse(null);
		
		p2.setBusinessClassPrice(pricemodify.getBusinessClassPrice());
		p2.setEconomyClassPrice(pricemodify.getEconomyClassPrice());
		p2.setFirstClassPrice(pricemodify.getFirstClassPrice());
			
			pricedao.save(p2);
		
		return p2;
	}

}
