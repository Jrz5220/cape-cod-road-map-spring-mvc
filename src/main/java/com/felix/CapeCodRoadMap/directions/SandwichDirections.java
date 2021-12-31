package com.felix.CapeCodRoadMap.directions;

public class SandwichDirections extends CapeCodDirections {
	
	private String origin;
	private String[] capeCodTowns;
	
	public SandwichDirections() {
		super();
		origin = CapeCodRoadMap.SANDWICH;
		capeCodTowns = CapeCodRoadMap.getTowns();
		for(String town : capeCodTowns) {
			if(!town.equals(origin))
				calculateDirections(origin, town, true);
		}
	}

}
