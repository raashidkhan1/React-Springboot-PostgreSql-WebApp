package com.test.application.models;

import java.util.List;

public class HighestLowestVaccinations {

	private final List<ReportRow> highest;
	
	private final List<ReportRow> lowest;

	public HighestLowestVaccinations(List<ReportRow> highest, List<ReportRow> lowest) {
		this.highest = highest;
		this.lowest = lowest;
	}

	public List<ReportRow> getHighest() {
		return highest;
	}

	public List<ReportRow> getLowest() {
		return lowest;
	}
	
	
}
