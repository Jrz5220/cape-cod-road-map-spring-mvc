package com.felix.CapeCodRoadMap.directions;

public class ChathamDirections extends CapeCodDirections {
	
	private String origin;
	private String[] capeCodTowns;
	
	public ChathamDirections() {
		super();
		origin = CapeCodRoadMap.CHATHAM;
		capeCodTowns = CapeCodRoadMap.getTowns();
		for(String town : capeCodTowns) {
			if(!town.equals(origin))
				calculateDirections(origin, town, true);
		}
	}

}
