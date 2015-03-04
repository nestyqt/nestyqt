package com.exam.recipefinder.model;

public class Input {
	private String fridgeFilePath;
	public String getFridgeFilePath() {
		return fridgeFilePath;
	}
	public void setFridgeFilePath(String fridgeFilePath) {
		this.fridgeFilePath = fridgeFilePath;
	}
	public String getRecipeFilePath() {
		return recipeFilePath;
	}
	public void setRecipeFilePath(String recipeFilePath) {
		this.recipeFilePath = recipeFilePath;
	}
	private String recipeFilePath;
}
