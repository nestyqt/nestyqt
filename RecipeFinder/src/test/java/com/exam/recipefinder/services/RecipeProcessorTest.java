package com.exam.recipefinder.services;

import junit.framework.Assert;

import org.junit.Test;

public class RecipeProcessorTest {
		
	@Test
	public void recipeProcessor_ReturnsSaladSandwich() {
		String recipe = RecipeProcessor.findRecipe("src/test/resources/fridge_validDelimeters.csv", 
				"src/test/resources/recipe_SaladSandwich.json");
		System.out.println("Suggested Recipe:" +  recipe);
		Assert.assertTrue(recipe.contains("salad sandwich"));
	}
	
	@Test
	public void recipeProcessor_ReturnsGrilledCheeseOnToast() {
		String recipe = RecipeProcessor.findRecipe("src/test/resources/fridge_validDelimeters.csv", 
				"src/test/resources/recipe_GrilledCheeseOnToast.json");
		Assert.assertTrue(recipe.contains("grilled cheese on toast"));
	}
	
	@Test
	public void recipeProcessor_NoRecipeFound() {
		String recipe = RecipeProcessor.findRecipe("src/test/resources/fridge_validDelimeters.csv", 
				"src/test/resources/recipe_testGrilledCheeseOnToast.jsons");
		Assert.assertEquals(RecipeProcessor.takeout(), recipe);
	}

}
