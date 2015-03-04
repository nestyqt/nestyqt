package com.exam.recipefinder.services;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

import org.joda.time.Days;
import org.joda.time.LocalDate;

import com.exam.recipefinder.model.FridgeItem;
import com.exam.recipefinder.model.Item;
import com.exam.recipefinder.model.Recipe;

public class RecipeProcessor {

	public static String findRecipe(String srcFridge, String srcRecipe) {
		
		List<Recipe> recipes = null;
		try {
			FridgeService.parseItems(srcFridge);
			recipes = RecipeService.parseItems(srcRecipe);
		} catch (Exception e) {
			//e.printStackTrace();
			return takeout();
		}
		
		Map<String, Integer> validRecipes = new HashMap<>();
		for (Recipe recipe : recipes) {			

			for (Item ingredient : recipe.getIngredients()) {
				FridgeItem fridgeItem = FridgeService.getItem(ingredient.getItem());
				if (!isValid(recipe.getName(), ingredient, fridgeItem, validRecipes)) {
					validRecipes.remove(recipe.getName());
					break;
				}				
			}			
			
		}
		
		if (validRecipes.size()==0){
			return takeout();
		}
		else{
			System.out.println(entriesSortedByValues(validRecipes).first());
			Recipe suggestedRecipe = RecipeService.getRecipe(entriesSortedByValues(validRecipes).first().getKey());
			return suggestedRecipe.toString();
		}
	}

	private static boolean isValid(String name, Item ingredient, FridgeItem item, Map<String, Integer> validRecipes) {
		if (item == null 
				|| !item.getUnit().equals(ingredient.getUnit())
				|| item.getAmount() < ingredient.getAmount()){
			return false;
		}
		LocalDate today = new LocalDate();
		LocalDate useBy = new LocalDate(item.getUseBy());
		if (useBy.isBefore(today)){
			return false;
		}
		
		if (validRecipes.size()==0 || 
			validRecipes.get(name) == null || 
			validRecipes.get(name) != null && validRecipes.get(name) > Days.daysBetween(today, useBy).getDays()){
			validRecipes.put(name, Days.daysBetween(today, useBy).getDays());
		}
		return true;
	}
	
	static <K,V extends Comparable<? super V>> SortedSet<Map.Entry<K,V>> entriesSortedByValues(Map<K,V> map) {
	    SortedSet<Map.Entry<K,V>> sortedEntries = new TreeSet<Map.Entry<K,V>>(
	        new Comparator<Map.Entry<K,V>>() {
	            @Override public int compare(Map.Entry<K,V> e1, Map.Entry<K,V> e2) {
	                int res = e1.getValue().compareTo(e2.getValue());
	                if (e1.getKey().equals(e2.getKey())) {
	                    return res; // Code will now handle equality properly
	                } else {
	                    return res != 0 ? res : 1; // While still adding all entries
	                }
	            }
	        }
	    );
	    sortedEntries.addAll(map.entrySet());
	    return sortedEntries;
	}
	
	public static String takeout(){
		return "Order Takeout";
	}

}
