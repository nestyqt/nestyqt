package com.exam.recipefinder.model;

import org.codehaus.jackson.annotate.JsonProperty;

public class Recipe{
	
	private String name;
	@JsonProperty("ingredients")
	Item[] ingredients;
	
	

	public Item[] getIngredients() {
		return ingredients;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}

//	@Override
//	public String toString() {
//		StringBuffer sb = new StringBuffer();
//		sb.append("Recipe{ name='" + name + '\'' + ", ingredients=");
//		for (Item item : getIngredients()){
//			System.out.println(item.toString());
//			sb.append(item.toString());
//		}
//		sb.append('}');
//		return sb.toString();
//	}
	
}
