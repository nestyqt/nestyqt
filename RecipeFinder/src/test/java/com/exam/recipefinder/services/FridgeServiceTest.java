package com.exam.recipefinder.services;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import junitx.framework.ListAssert;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Test;

import com.exam.recipefinder.model.FridgeItem;
import com.exam.recipefinder.model.Unit;

public class FridgeServiceTest {
	private static final DateTimeFormatter FORMATTER = DateTimeFormat.forPattern("dd/MM/yyyy");
	
	private List<FridgeItem> getFridgeItems(){
		List<FridgeItem> myfridge = new ArrayList<>();
		myfridge.add(new FridgeItem("bread", 10, Unit.SLICES, FORMATTER.parseLocalDate("09/03/2015")));
		myfridge.add(new FridgeItem("cheese", 10, Unit.SLICES, FORMATTER.parseLocalDate("05/03/2015")));
		myfridge.add(new FridgeItem("butter", 250, Unit.GRAMS, FORMATTER.parseLocalDate("05/03/2015")));
		myfridge.add(new FridgeItem("peanut butter", 250, Unit.GRAMS, FORMATTER.parseLocalDate("02/03/2015")));
		myfridge.add(new FridgeItem("mixed salad", 150, Unit.GRAMS, FORMATTER.parseLocalDate("04/03/2015")));
		myfridge.add(new FridgeItem("jelly", 5, Unit.GRAMS, FORMATTER.parseLocalDate("07/03/2015")));
		return myfridge;
	}
	
	
	@Test(expected = Exception.class)
	public void parseFridgeItem_ShouldThrowException_WhenItemArgumentIsNull() {		
		FridgeService.parseItems(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void parseFridgeItem_ShouldThrowException_WhenItemArgumentDoesntExist() {		
		FridgeService.parseItems("c:\test\testing.csv");
	}
	
	@Test
	public void parseFridgeItem_ReturnZero_WhenItemArgumentIsEmpty() {
		List<FridgeItem> fridgeItems = FridgeService.parseItems("src/test/resources/empty.txt");		
		Assert.assertEquals(0, fridgeItems.size());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void parseFridgeItem_ShouldThrowException_WhenInvalidDelimeter() {
		FridgeService.parseItems("src/test/resources/fridge_invalidDelimeters.csv");
	}
	
	@Test
	public void parseFridgeItem_ReturnList_WhenValidDelimeter() {
		List<FridgeItem> current = FridgeService.parseItems("src/test/resources/fridge_validDelimeters.csv");
		Assert.assertEquals(getFridgeItems().toString(), current.toString());
	}


}
