package org.p0gram3r.codingdojo;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class NumberTranslatorTest {

    @Test
    public void translateOutOfRange () {
    	
    	List<Long> testData = new ArrayList<>();
    	testData.add(0L);
    	testData.add(-10L);
    	testData.add(5000000000000L);
    	
    	NumberTranslator numberTranslator = new NumberTranslator();
    	for (Long number : testData) {
    		String wordNumber = numberTranslator.translate(number.longValue());
    		assertThat(wordNumber, is(equalTo("Out of range")));
       	}
    }
    
    @Test
    public void translateHappyCases () {
    	Map<Long, String> testData = new HashMap<>();
    	testData.put(7L, "Seven");
    	testData.put(10L, "Ten");
    	testData.put(19L, "Nineteen");
    	testData.put(20L, "Twenty");
    	testData.put(99L, "Ninety Nine");
    	testData.put(100L, "One Hundred");
    	testData.put(105L, "One Hundred and Five");
    	testData.put(325L, "Three Hundred and Twenty Five");
    	testData.put(999L, "Nine Hundred and Ninety Nine");
    	testData.put(1000L, "One Thousand");
    	testData.put(1005L, "One Thousand Five");
    	testData.put(11345L, "Eleven Thousand Three Hundred and Forty Five");
    	testData.put(999345L, "Nine Hundred and Ninety Nine Thousand Three Hundred and Forty Five");
    	testData.put(2000000L, "Two Million");
    	testData.put(5000000000L, "Five Billion");
    	
    	NumberTranslator numberTranslator = new NumberTranslator();
    	for (Long number : testData.keySet()) {
    		String wordNumber = numberTranslator.translate(number.longValue());
    		assertThat(wordNumber, is(equalTo(testData.get(number))));
       	}
 	
    }
    
}
