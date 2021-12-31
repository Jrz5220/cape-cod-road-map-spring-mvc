package com.felix.CapeCodRoadMap.directions;

public class HyannisDirections extends CapeCodDirections {
	
	private String origin;
	private String[] capeCodTowns;
	
	public HyannisDirections() {
		super();
		origin = CapeCodRoadMap.HYANNIS;
		capeCodTowns = CapeCodRoadMap.getTowns();
		for(String town : capeCodTowns) {
			if(!town.equals(origin))
				calculateDirections(origin, town, true);
		}
	}

}
