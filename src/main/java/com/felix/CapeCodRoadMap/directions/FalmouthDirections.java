package com.felix.CapeCodRoadMap.directions;

public class FalmouthDirections extends CapeCodDirections {
	
	private String origin;
	private String[] capeCodTowns;
	
	public FalmouthDirections() {
		super();
		origin = CapeCodRoadMap.FALMOUTH;
		capeCodTowns = CapeCodRoadMap.getTowns();
		for(String town : capeCodTowns) {
			if(!town.equals(origin))
				calculateDirections(origin, town, true);
		}
	}

}
