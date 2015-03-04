package com.exam.recipefinder.services;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;

import com.exam.recipefinder.model.Recipe;

public class RecipeService {
	
	private static Map<String, Recipe> mapItems = new HashMap<>();


	public static List<Recipe> parseItems(String source) throws Exception{
		List<Recipe> recipes = null;
		ObjectMapper mapper = new ObjectMapper();
		recipes = mapper.readValue(new File(source), mapper.getTypeFactory().constructCollectionType(List.class, Recipe.class));
		
		for (Recipe recipe : recipes){
			mapItems.put(recipe.getName(), recipe);
		}
		
		return recipes;
	}
	
	public static Recipe getRecipe(String key){
		return mapItems.get(key);
	}

}
