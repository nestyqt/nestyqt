package com.exam.recipefinder.services;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import au.com.bytecode.opencsv.CSVReader;

import com.exam.recipefinder.model.FridgeItem;

public class FridgeService {
	
	private static Map<String, FridgeItem> mapItems = new HashMap<>();	
	
	public static List<FridgeItem> parseItems(String source) throws IllegalArgumentException {
		List<FridgeItem> items = new ArrayList<>();
		int currentRow = 0;
		try (CSVReader reader = new CSVReader(new FileReader(source), ',')) {
			String[] nextItem;
			while((nextItem = reader.readNext()) != null) {
				currentRow++;
				FridgeItem item = ItemParser.parseItem(nextItem);
				//System.out.println(item.toString());
				items.add(item);
				
				//Add to map for get
				mapItems.put(item.getItem(), item);
			}
		} 
		catch (Exception e ) {
			//System.out.println(e.getMessage());
			String message = "Failed to parse line " + currentRow + ". " + e.getLocalizedMessage();
			//throw new Exception(message, e);
			throw new IllegalArgumentException(message, e);
		}
		return items;
	}
	
	public static FridgeItem getItem(String key){
		return mapItems.get(key);
	}
}
