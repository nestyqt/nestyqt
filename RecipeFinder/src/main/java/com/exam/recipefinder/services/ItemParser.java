package com.exam.recipefinder.services;

import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.exam.recipefinder.model.FridgeItem;
import com.exam.recipefinder.model.Unit;

public class ItemParser {

	public static FridgeItem parseItem(String[] columns) {
//		checkArgument(columns.length == 4,
//				"Expected 4 fields for item, instead of: [%s]",
//				Arrays.toString(columns));
		return new FridgeItem((columns[0]).trim(),
						getAmount((columns[1]).trim()),
						getUnit((columns[2]).trim()),
						getDate((columns[3]).trim())
						);
	}

	private static int getAmount(String amount) {
		return Integer.parseInt(amount);
	}

	private static Unit getUnit(String unit) {
		return Unit.valueOf(unit.toUpperCase());
	}

	private static LocalDate getDate(String date) {
		DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy");
		return formatter.parseLocalDate(date);
	}

}
