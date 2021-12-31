package com.felix.CapeCodRoadMap.directions;

public class ProvDirections extends CapeCodDirections {
	
	private String origin;
	private String[] capeCodTowns;
	
	public ProvDirections() {
		super();
		origin = CapeCodRoadMap.PROVINCETOWN;
		capeCodTowns = CapeCodRoadMap.getTowns();
		for(String town : capeCodTowns) {
			if(!town.equals(origin))
				calculateDirections(origin, town, true);
		}
	}

}
