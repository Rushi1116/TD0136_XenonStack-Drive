package com.cdac.dto;

public class PriceModify 
{
	
		private double businessClassPrice;
		private double economyClassPrice;
		private double firstClassPrice;


		public double getBusinessClassPrice() {
			return businessClassPrice;
		}
		public void setBusinessClassPrice(double businessClassPrice) {
			this.businessClassPrice = businessClassPrice;
		}
		public double getEconomyClassPrice() {
			return economyClassPrice;
		}
		public void setEconomyClassPrice(double economyClassPrice) {
			this.economyClassPrice = economyClassPrice;
		}
		public double getFirstClassPrice() {
			return firstClassPrice;
		}
		public void setFirstClassPrice(double firstClassPrice) {
			this.firstClassPrice = firstClassPrice;
		}
		public PriceModify( double businessClassPrice, double economyClassPrice, double firstClassPrice) {
			super();
			
			this.businessClassPrice = businessClassPrice;
			this.economyClassPrice = economyClassPrice;
			this.firstClassPrice = firstClassPrice;
		}

}
