package org.p0gram3r.codingdojo;

import java.util.HashMap;
import java.util.Map;

public class NumberTranslator {
	
	private Map<Integer, String> units = new HashMap<>();
	private Map<Integer, String> tenths = new HashMap<>();
	private Map<Integer, String> magnitudes = new HashMap<>();
	
	public NumberTranslator() {
		units.put(1, "One");
		units.put(2, "Two");
		units.put(3, "Three");
		units.put(4, "Four");
		units.put(5, "Five");
		units.put(6, "Six");
		units.put(7, "Seven");
		units.put(8, "Eight");
		units.put(9, "Nine");
		units.put(10, "Ten");
		units.put(11, "Eleven");
		units.put(12, "Twelve");
		units.put(13, "Thirteen");
		units.put(14, "Fourteen");
		units.put(15, "Fifteen");
		units.put(16, "Sixteen");
		units.put(17, "Seventeen");
		units.put(18, "Eighteen");
		units.put(19, "Nineteen");
		
		tenths.put(2, "Twenty");
		tenths.put(3, "Thirty");
		tenths.put(4, "Fourty");
		tenths.put(5, "Fifty");
		tenths.put(6, "Sixty");
		tenths.put(7, "Seventy");
		tenths.put(8, "Eighty");
		tenths.put(9, "Ninety");
	
		magnitudes.put(0, null);
		magnitudes.put(1, null);
		magnitudes.put(2, "Hundread and");
		magnitudes.put(3, "Thousand");
		magnitudes.put(4, "Million");
		magnitudes.put(5, "Billion");
	}
	
	public String translate(Integer number) {
		if (number == null) {
			return "Invalid Number";
		}
		String result = null;
		
		if (number < 20) {
			result = units.get(number);
		} else {
			int unit = number%10;
			int tenth = number/10;
			result = (unit > 0) ? tenths.get(tenth)+" "+units.get(unit) : tenths.get(tenth);				
		}
		return (result != null) ? result : "Invalid Number";
	}

}
