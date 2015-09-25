package org.p0gram3r.codingdojo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NumberTranslator {
	
	private Map<Integer, String> numbers = new HashMap<>();
	private Map<Integer, String> tenths = new HashMap<>();
	private Map<Integer, String> prefix = new HashMap<>();
	
	public NumberTranslator() {
		numbers.put(1, "One");
		numbers.put(2, "Two");
		numbers.put(3, "Three");
		numbers.put(4, "Four");
		numbers.put(5, "Five");
		numbers.put(6, "Six");
		numbers.put(7, "Seven");
		numbers.put(8, "Eight");
		numbers.put(9, "Nine");
		numbers.put(10, "Ten");
		numbers.put(11, "Eleven");
		numbers.put(12, "Twelve");
		numbers.put(13, "Thirteen");
		numbers.put(14, "Fourteen");
		numbers.put(15, "Fifteen");
		numbers.put(16, "Sixteen");
		numbers.put(17, "Seventeen");
		numbers.put(18, "Eighteen");
		numbers.put(19, "Nineteen");
		
		tenths.put(2, "Twenty");
		tenths.put(3, "Thirty");
		tenths.put(4, "Forty");
		tenths.put(5, "Fifty");
		tenths.put(6, "Sixty");
		tenths.put(7, "Seventy");
		tenths.put(8, "Eighty");
		tenths.put(9, "Ninety");
	
		prefix.put(1, "Thousand");
		prefix.put(2, "Million");
		prefix.put(3, "Billion");
	}
	
	public String translate(long number) {
		 
		ArrayList<Long> numberSplit = new ArrayList<>();
		
		while (number > 0) {
			numberSplit.add(number%1000);
			number /= 1000;
			if (number < 1000) {
				numberSplit.add(number);
				number = 0;
			}
		}
		String result = "";
		int prefixIdx = numberSplit.size() -1;
		
		if (!prefix.containsKey(prefixIdx)) {
			return "Out of range";
		}
		
		for (int idx = numberSplit.size()-1; idx >= 0 ; idx--) {
			int part = numberSplit.get(idx).intValue();
			if (part > 0) {
				if ( part / 100 > 0) {
					result += numbers.get(part/100);
					result += ( part % 100 > 0) ? " Hundred and " : " Hundred ";
				}
				if ( part % 100 > 0) {
					if ( numbers.containsKey(part%100) ) {
						result += numbers.get(part%100);
					} else {
						result += tenths.get((part%100) / 10) + " ";
						result += ((part%100) %10 > 0) ? numbers.get((part%100) % 10) : "";
					}
				}
				if (prefix.containsKey(prefixIdx)) {
					result += " "+prefix.get(prefixIdx) + " ";
				}
			}
			prefixIdx -= 1;
		}
		return (result == "") ? "Out of range" : result.trim();
	}

}
