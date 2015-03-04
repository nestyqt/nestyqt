package com.exam.recipefinder.model;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonValue;

public enum Unit {
	OF, GRAMS, ML, SLICES;

	@JsonValue
	public String toJson() {
		return name().toLowerCase();
	}

	@JsonCreator
	public static Unit fromJson(String text) {
		return valueOf(text.toUpperCase());
	}
}
