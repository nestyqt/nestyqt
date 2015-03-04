package com.exam.recipefinder.model;

import java.util.Date;

import org.joda.time.LocalDate;

public class Item {

	private String item;
	private int amount;
	private Unit unit;
	
	public Item(){}

	public Item(String item, int amount, Unit unit) {
		this.item = item;
		this.amount = amount;
		this.unit = unit;
	}
	
	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}

	@Override
	public String toString() {
		return "Item{" + "item='" + item + '\'' + ", amount=" + amount
				+ ", unit=" + unit + '}';
	}

}
