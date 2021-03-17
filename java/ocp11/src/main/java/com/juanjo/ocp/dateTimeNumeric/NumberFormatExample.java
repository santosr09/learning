package com.juanjo.ocp.dateTimeNumeric;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class NumberFormatExample {
	
	public final int CONSTANT_VALUE;
	
	{CONSTANT_VALUE = 0;} // If removed Code won't compile: Variable 'CONSTANT_VALUE' might not have been initialized
	
	public static void main(String[] args) throws ParseException {
		BigDecimal price = BigDecimal.valueOf(2.99);
		Double tax = 0.2;
		int quantity = 123;
		Locale locale = new Locale("es", "MX");
		NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(locale);
		NumberFormat percentegeFormat = NumberFormat.getPercentInstance(locale);
		NumberFormat numberFormat = NumberFormat.getNumberInstance(locale);
		String formattedPrice = currencyFormat.format(price);
		String formattedTax = percentegeFormat.format(tax);
		String formattedQuantity = numberFormat.format(quantity);
		
		Double newPrice = (Double) currencyFormat.parse("$4.30");
		//Double newTax = (Double) percentegeFormat.parse("12%");
		int newQuantity = numberFormat.parse("54,231").intValue();
		
	}
	
	class Product {
		private final String name = "Tea";
		private final BigDecimal price = BigDecimal.ZERO;
		public BigDecimal getDiscount(final BigDecimal discount) {
			return price.multiply(discount);
		}
	}
	
}
