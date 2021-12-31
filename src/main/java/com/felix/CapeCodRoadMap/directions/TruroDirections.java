package com.felix.CapeCodRoadMap.directions;

public class TruroDirections extends CapeCodDirections {
	
	private String origin;
	private String[] capeCodTowns;
	
	public TruroDirections() {
		super();
		origin = CapeCodRoadMap.TRURO;
		capeCodTowns = CapeCodRoadMap.getTowns();
		for(String town : capeCodTowns) {
			if(!town.equals(origin))
				calculateDirections(origin, town, true);
		}
	}

}
