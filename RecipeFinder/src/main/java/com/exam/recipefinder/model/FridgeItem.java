package com.exam.recipefinder.model;

import java.util.Date;

import org.joda.time.LocalDate;

public class FridgeItem extends Item {
	private Date useBy;

	public Date getUseBy() {
		return useBy;
	}

	public FridgeItem(String item, int amount, Unit unit, LocalDate useBy) {	
		super(item, amount, unit);
		setUseBy(useBy.toDate());
	}

	public void setUseBy(Date useBy) {
		this.useBy = useBy;
	}

	@Override
	public String toString() {
		return "FridgeItem{" + super.toString() + ", useBy=" + useBy + '}';
	}

}
