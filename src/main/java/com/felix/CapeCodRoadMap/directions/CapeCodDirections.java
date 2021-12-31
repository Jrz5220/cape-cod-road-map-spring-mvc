package com.felix.CapeCodRoadMap.directions;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedList;

import com.google.maps.DirectionsApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.PendingResult;
import com.google.maps.model.DirectionsLeg;
import com.google.maps.model.DirectionsResult;
import com.google.maps.model.DirectionsStep;

public class CapeCodDirections implements CapeCodDirectionsInterface {
	
	private GeoApiContext context;
	private LinkedList<String> stepsToDestination;
	private LinkedList<String> cheapestPath;
	
	public CapeCodDirections() {
		context = TheGeoApiContext.getGeoApiContext();
		stepsToDestination = new LinkedList<>();
		cheapestPath = new LinkedList<>();
	}
	
	protected final void calculateDirections(String origin, String destination, Boolean setWaypoints) {
		DirectionsApiRequest apiRequest = new DirectionsApiRequest(context);
		String town, waypoint, directionsKey, durationKey, distanceKey;
		String capOrigin = "";
		String capDest = "";
		String[] waypoints = new String[0];
		if(origin == null)
			origin = "";
		if(destination == null)
			destination = "";
		if(origin.length() > 1 && destination.length() > 1) {
			capOrigin = origin.substring(0, 1).toUpperCase() + origin.substring(1);
			capDest = destination.substring(0, 1).toUpperCase() + destination.substring(1);
		}
		directionsKey = origin + "To" + capDest;
		durationKey = directionsKey + "Duration";
		distanceKey = directionsKey + "Distance";
		stepsToDestination.clear();
		// set waypoints for this route
		if(setWaypoints) {
			if(!destination.equalsIgnoreCase(origin)) {
				cheapestPath.clear();
				CapeCodRoadMap.getRoadMap().getCheapestPath(origin, destination, cheapestPath);
				if(cheapestPath.size() >= 2)
					waypoints = new String[cheapestPath.size() - 2];
				for(int i = 0; i < waypoints.length; i++) {
					town = cheapestPath.get(i + 1);
					waypoint = town.substring(0, 1).toUpperCase() + town.substring(1) + ", MA";
					waypoints[i] = waypoint;
				}
			}
		}
		origin = capOrigin + ", MA";
		destination = capDest + ", MA";
		apiRequest.departureTimeNow().origin(origin).destination(destination).waypoints(waypoints).setCallback(new PendingResult.Callback<DirectionsResult>() {
			@Override
			public void onResult(DirectionsResult result) {
				DirectionsLeg[] routeLegs = result.routes[0].legs;
				for(int i = 0; i < routeLegs.length; i++) {
					int legDurationInMin = Math.round(routeLegs[i].duration.inSeconds / 60);
					double legDistanceInMiles = routeLegs[i].distance.inMeters * 0.000621371;
					String legRoute = "<b class=\"orange-text\">" + routeLegs[i].startAddress + " &#10132 " + routeLegs[i].endAddress + "</b>";
					DirectionsStep[] routeSteps = routeLegs[i].steps;
					CapeCodHashMap.getDirectionsMap().get(directionsKey).add(legRoute);
					CapeCodHashMap.getDurationsMap().get(durationKey).add(legDurationInMin);
					CapeCodHashMap.getDistancesMap().get(distanceKey).add(legDistanceInMiles);
					for(int j = 0; j < routeSteps.length; j++) {
						CapeCodHashMap.getDirectionsMap().get(directionsKey).add(routeSteps[j].htmlInstructions);
					}
				}
			}
			@Override
			public void onFailure(Throwable e) {
				System.out.println("Failed to get directions: " + e.getMessage());
			}
		});
	}
	
	private int totalDuration(String key) {
		int totalDuration = 0;
		LinkedList<Integer> theDurations = CapeCodHashMap.getDurationsMap().get(key);
		if(theDurations != null) {
			for(int minutes : theDurations) {
				totalDuration += minutes;
			}
		}
		return totalDuration;
	}
	
	private double totalDistance(String key) {
		double totalDistance = 0.0;
		LinkedList<Double> theDistances = CapeCodHashMap.getDistancesMap().get(key);
		if(theDistances != null) {
			for(double miles : theDistances) {
				totalDistance += miles;
			}
			BigDecimal bd = BigDecimal.valueOf(totalDistance);
			bd = bd.setScale(1, RoundingMode.HALF_UP);
			totalDistance = bd.doubleValue();
		}
		return totalDistance;
	}

	@Override
	public LinkedList<String> getDirectionsToProvincetown(String origin) {
		String theKey = origin + "ToProvincetown";
		return CapeCodHashMap.getDirectionsMap().get(theKey);
	}

	@Override
	public int getDurationToProvincetown(String origin) {
		String theKey = origin + "ToProvincetownDuration";
		return totalDuration(theKey);
	}

	@Override
	public double getDistanceToProvincetown(String origin) {
		String theKey = origin + "ToProvincetownDistance";
		return totalDistance(theKey);
	}

	@Override
	public LinkedList<String> getDirectionsToTruro(String origin) {
		String theKey = origin + "ToTruro";
		return CapeCodHashMap.getDirectionsMap().get(theKey);
	}

	@Override
	public int getDurationToTruro(String origin) {
		String theKey = origin + "ToTruroDuration";
		return totalDuration(theKey);
	}

	@Override
	public double getDistanceToTruro(String origin) {
		String theKey = origin + "ToTruroDistance";
		return totalDistance(theKey);
	}

	@Override
	public LinkedList<String> getDirectionsToOrleans(String origin) {
		String theKey = origin + "ToOrleans";
		return CapeCodHashMap.getDirectionsMap().get(theKey);
	}

	@Override
	public int getDurationToOrleans(String origin) {
		String theKey = origin + "ToOrleansDuration";
		return totalDuration(theKey);
	}

	@Override
	public double getDistanceToOrleans(String origin) {
		String theKey = origin + "ToOrleansDistance";
		return totalDistance(theKey);
	}

	@Override
	public LinkedList<String> getDirectionsToChatham(String origin) {
		String theKey = origin + "ToChatham";
		return CapeCodHashMap.getDirectionsMap().get(theKey);
	}

	@Override
	public int getDurationToChatham(String origin) {
		String theKey = origin + "ToChathamDuration";
		return totalDuration(theKey);
	}

	@Override
	public double getDistanceToChatham(String origin) {
		String theKey = origin + "ToChathamDistance";
		return totalDistance(theKey);
	}

	@Override
	public LinkedList<String> getDirectionsToBarnstable(String origin) {
		String theKey = origin + "ToBarnstable";
		return CapeCodHashMap.getDirectionsMap().get(theKey);
	}

	@Override
	public int getDurationToBarnstable(String origin) {
		String theKey = origin + "ToBarnstableDuration";
		return totalDuration(theKey);
	}

	@Override
	public double getDistanceToBarnstable(String origin) {
		String theKey = origin + "ToBarnstableDistance";
		return totalDistance(theKey);
	}

	@Override
	public LinkedList<String> getDirectionsToHyannis(String origin) {
		String theKey = origin + "ToHyannis";
		return CapeCodHashMap.getDirectionsMap().get(theKey);
	}

	@Override
	public int getDurationToHyannis(String origin) {
		String theKey = origin + "ToHyannisDuration";
		return totalDuration(theKey);
	}

	@Override
	public double getDistanceToHyannis(String origin) {
		String theKey = origin + "ToHyannisDistance";
		return totalDistance(theKey);
	}

	@Override
	public LinkedList<String> getDirectionsToSandwich(String origin) {
		String theKey = origin + "ToSandwich";
		return CapeCodHashMap.getDirectionsMap().get(theKey);
	}

	@Override
	public int getDurationToSandwich(String origin) {
		String theKey = origin + "ToSandwichDuration";
		return totalDuration(theKey);
	}

	@Override
	public double getDistanceToSandwich(String origin) {
		String theKey = origin + "ToSandwichDistance";
		return totalDistance(theKey);
	}

	@Override
	public LinkedList<String> getDirectionsToFalmouth(String origin) {
		String theKey = origin + "ToFalmouth";
		return CapeCodHashMap.getDirectionsMap().get(theKey);
	}

	@Override
	public int getDurationToFalmouth(String origin) {
		String theKey = origin + "ToFalmouthDuration";
		return totalDuration(theKey);
	}

	@Override
	public double getDistanceToFalmouth(String origin) {
		String theKey = origin + "ToFalmouthDistance";
		return totalDistance(theKey);
	}

}
