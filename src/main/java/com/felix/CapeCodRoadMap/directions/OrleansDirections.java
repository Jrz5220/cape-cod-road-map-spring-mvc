package com.felix.CapeCodRoadMap.directions;

public class OrleansDirections extends CapeCodDirections {
	
	private String origin;
	private String[] capeCodTowns;
	
	public OrleansDirections() {
		super();
		origin = CapeCodRoadMap.ORLEANS;
		capeCodTowns = CapeCodRoadMap.getTowns();
		for(String town : capeCodTowns) {
			if(!town.equals(origin))
				calculateDirections(origin, town, true);
		}
	}

}
