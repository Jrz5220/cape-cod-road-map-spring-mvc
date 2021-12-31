package com.felix.CapeCodRoadMap.directions;

public class BarnstableDirections extends CapeCodDirections {
	
	private String origin;
	private String[] capeCodTowns;
	
	public BarnstableDirections() {
		super();
		origin = CapeCodRoadMap.BARNSTABLE;
		capeCodTowns = CapeCodRoadMap.getTowns();
		for(String town : capeCodTowns) {
			if(!town.equals(origin))
				calculateDirections(origin, town, true);
		}
	}

}
