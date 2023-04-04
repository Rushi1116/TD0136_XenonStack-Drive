package com.cdac.service;

import java.util.List;

import com.cdac.entities.Price;
import com.cdac.dto.PriceDetails;
import com.cdac.dto.PriceModify;

public interface PriceService {

 Price	addprice(Price price);
	
 List<PriceDetails> getPriceList();
 
 PriceDetails getPrice(int id);
 
 Price editPrice(PriceModify pricemodify,int id);
}
