package org.p0gram3r.codingdojo;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class NumberTranslatorTest {

    @Test
    public void translateOnlyPositiveIntegers () {
    	
    	Integer number = 7;
    	NumberTranslator numberTranslator = new NumberTranslator();
    	String wordNumber = numberTranslator.translate(number);
    	
    	assertThat(wordNumber, is(equalTo("Seven")));
    	
    }
    
    @Test
    public void translateOutOfRange () {
    	
    	List<Integer> numbers = Arrays.asList(0, -10, null);
    	NumberTranslator numberTranslator = new NumberTranslator();
    	for (Integer number : numbers) {
    		String wordNumber = numberTranslator.translate(number);
    		assertThat(wordNumber, is(equalTo("Invalid Number")));
       	}
    }
    
    @Test
    public void translateGreaterThanTen () {
    	
       	List<Integer> numbers = Arrays.asList(10, 19, 20, 99);
       	List<String> expectedWords = Arrays.asList("Ten", "Nineteen", "Twenty", "Ninety Nine");
    	NumberTranslator numberTranslator = new NumberTranslator();
    	for (int i = 1; i < numbers.size(); i++) {
    		String wordNumber = numberTranslator.translate(numbers.get(i));
    		assertThat(wordNumber, is(equalTo(expectedWords.get(i))));
       	}
 	
    }
    @Test
    public void translateHundreds () {
    	
    	List<Integer> numbers = Arrays.asList(100, 105, 325, 999);
       	List<String> expectedWords = Arrays.asList("One Hundread", "One Hundread and Five", 
       			"Three Hundread and Twenty Five", "Nine Hundread and Ninety Nine");
    	NumberTranslator numberTranslator = new NumberTranslator();
    	for (int i = 1; i < numbers.size(); i++) {
    		String wordNumber = numberTranslator.translate(numbers.get(i));
    		assertThat(wordNumber, is(equalTo(expectedWords.get(i))));
       	}
 	
    }
}
