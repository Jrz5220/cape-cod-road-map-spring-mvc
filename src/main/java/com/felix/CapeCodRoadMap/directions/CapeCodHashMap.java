package com.felix.CapeCodRoadMap.directions;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

// Bill Pugh's singleton pattern
public final class CapeCodHashMap {
	
	private static final LinkedList<String> THE_DIRECTION_KEYS = new LinkedList<>();
	private static final LinkedList<String> THE_DURATION_KEYS = new LinkedList<>();
	private static final LinkedList<String> THE_DISTANCE_KEYS = new LinkedList<>();
	
	private final Map<String, LinkedList<String>> theDirections = new HashMap<>();
	private final Map<String, LinkedList<Integer>> theDurations = new HashMap<>();
	private final Map<String, LinkedList<Double>> theDistances = new HashMap<>();
	
	private CapeCodHashMap() {
		// prov direction keys
		THE_DIRECTION_KEYS.add("provincetownToTruro");
		THE_DIRECTION_KEYS.add("provincetownToOrleans");
		THE_DIRECTION_KEYS.add("provincetownToChatham");
		THE_DIRECTION_KEYS.add("provincetownToBarnstable");
		THE_DIRECTION_KEYS.add("provincetownToHyannis");
		THE_DIRECTION_KEYS.add("provincetownToSandwich");
		THE_DIRECTION_KEYS.add("provincetownToFalmouth");
		// truro direction key
		THE_DIRECTION_KEYS.add("truroToProvincetown");
		THE_DIRECTION_KEYS.add("truroToOrleans");
		THE_DIRECTION_KEYS.add("truroToChatham");
		THE_DIRECTION_KEYS.add("truroToBarnstable");
		THE_DIRECTION_KEYS.add("truroToHyannis");
		THE_DIRECTION_KEYS.add("truroToSandwich");
		THE_DIRECTION_KEYS.add("truroToFalmouth");
		// orleans direction keys
		THE_DIRECTION_KEYS.add("orleansToProvincetown");
		THE_DIRECTION_KEYS.add("orleansToTruro");
		THE_DIRECTION_KEYS.add("orleansToChatham");
		THE_DIRECTION_KEYS.add("orleansToBarnstable");
		THE_DIRECTION_KEYS.add("orleansToHyannis");
		THE_DIRECTION_KEYS.add("orleansToSandwich");
		THE_DIRECTION_KEYS.add("orleansToFalmouth");
		// chatham direction keys
		THE_DIRECTION_KEYS.add("chathamToProvincetown");
		THE_DIRECTION_KEYS.add("chathamToTruro");
		THE_DIRECTION_KEYS.add("chathamToOrleans");
		THE_DIRECTION_KEYS.add("chathamToBarnstable");
		THE_DIRECTION_KEYS.add("chathamToHyannis");
		THE_DIRECTION_KEYS.add("chathamToSandwich");
		THE_DIRECTION_KEYS.add("chathamToFalmouth");
		// barnstable direction keys
		THE_DIRECTION_KEYS.add("barnstableToProvincetown");
		THE_DIRECTION_KEYS.add("barnstableToTruro");
		THE_DIRECTION_KEYS.add("barnstableToOrleans");
		THE_DIRECTION_KEYS.add("barnstableToChatham");
		THE_DIRECTION_KEYS.add("barnstableToHyannis");
		THE_DIRECTION_KEYS.add("barnstableToSandwich");
		THE_DIRECTION_KEYS.add("barnstableToFalmouth");
		// hyannis direction keys
		THE_DIRECTION_KEYS.add("hyannisToProvincetown");
		THE_DIRECTION_KEYS.add("hyannisToTruro");
		THE_DIRECTION_KEYS.add("hyannisToOrleans");
		THE_DIRECTION_KEYS.add("hyannisToChatham");
		THE_DIRECTION_KEYS.add("hyannisToBarnstable");
		THE_DIRECTION_KEYS.add("hyannisToSandwich");
		THE_DIRECTION_KEYS.add("hyannisToFalmouth");
		// sandwich direction keys
		THE_DIRECTION_KEYS.add("sandwichToProvincetown");
		THE_DIRECTION_KEYS.add("sandwichToTruro");
		THE_DIRECTION_KEYS.add("sandwichToOrleans");
		THE_DIRECTION_KEYS.add("sandwichToChatham");
		THE_DIRECTION_KEYS.add("sandwichToBarnstable");
		THE_DIRECTION_KEYS.add("sandwichToHyannis");
		THE_DIRECTION_KEYS.add("sandwichToFalmouth");
		// falmouth direction keys
		THE_DIRECTION_KEYS.add("falmouthToProvincetown");
		THE_DIRECTION_KEYS.add("falmouthToTruro");
		THE_DIRECTION_KEYS.add("falmouthToOrleans");
		THE_DIRECTION_KEYS.add("falmouthToChatham");
		THE_DIRECTION_KEYS.add("falmouthToBarnstable");
		THE_DIRECTION_KEYS.add("falmouthToHyannis");
		THE_DIRECTION_KEYS.add("falmouthToSandwich");
		
		
		// prov duration keys
		THE_DURATION_KEYS.add("provincetownToTruroDuration");
		THE_DURATION_KEYS.add("provincetownToOrleansDuration");
		THE_DURATION_KEYS.add("provincetownToChathamDuration");
		THE_DURATION_KEYS.add("provincetownToBarnstableDuration");
		THE_DURATION_KEYS.add("provincetownToHyannisDuration");
		THE_DURATION_KEYS.add("provincetownToSandwichDuration");
		THE_DURATION_KEYS.add("provincetownToFalmouthDuration");
		// truro duration keys
		THE_DURATION_KEYS.add("truroToProvincetownDuration");
		THE_DURATION_KEYS.add("truroToOrleansDuration");
		THE_DURATION_KEYS.add("truroToChathamDuration");
		THE_DURATION_KEYS.add("truroToBarnstableDuration");
		THE_DURATION_KEYS.add("truroToHyannisDuration");
		THE_DURATION_KEYS.add("truroToSandwichDuration");
		THE_DURATION_KEYS.add("truroToFalmouthDuration");
		// orleans duration keys
		THE_DURATION_KEYS.add("orleansToProvincetownDuration");
		THE_DURATION_KEYS.add("orleansToTruroDuration");
		THE_DURATION_KEYS.add("orleansToChathamDuration");
		THE_DURATION_KEYS.add("orleansToBarnstableDuration");
		THE_DURATION_KEYS.add("orleansToHyannisDuration");
		THE_DURATION_KEYS.add("orleansToSandwichDuration");
		THE_DURATION_KEYS.add("orleansToFalmouthDuration");
		// chatham duration keys
		THE_DURATION_KEYS.add("chathamToProvincetownDuration");
		THE_DURATION_KEYS.add("chathamToTruroDuration");
		THE_DURATION_KEYS.add("chathamToOrleansDuration");
		THE_DURATION_KEYS.add("chathamToBarnstableDuration");
		THE_DURATION_KEYS.add("chathamToHyannisDuration");
		THE_DURATION_KEYS.add("chathamToSandwichDuration");
		THE_DURATION_KEYS.add("chathamToFalmouthDuration");
		// barnstable duration keys
		THE_DURATION_KEYS.add("barnstableToProvincetownDuration");
		THE_DURATION_KEYS.add("barnstableToTruroDuration");
		THE_DURATION_KEYS.add("barnstableToOrleansDuration");
		THE_DURATION_KEYS.add("barnstableToChathamDuration");
		THE_DURATION_KEYS.add("barnstableToHyannisDuration");
		THE_DURATION_KEYS.add("barnstableToSandwichDuration");
		THE_DURATION_KEYS.add("barnstableToFalmouthDuration");
		// hyannis duration keys
		THE_DURATION_KEYS.add("hyannisToProvincetownDuration");
		THE_DURATION_KEYS.add("hyannisToTruroDuration");
		THE_DURATION_KEYS.add("hyannisToOrleansDuration");
		THE_DURATION_KEYS.add("hyannisToChathamDuration");
		THE_DURATION_KEYS.add("hyannisToBarnstableDuration");
		THE_DURATION_KEYS.add("hyannisToSandwichDuration");
		THE_DURATION_KEYS.add("hyannisToFalmouthDuration");
		// sandwich duration keys
		THE_DURATION_KEYS.add("sandwichToProvincetownDuration");
		THE_DURATION_KEYS.add("sandwichToTruroDuration");
		THE_DURATION_KEYS.add("sandwichToOrleansDuration");
		THE_DURATION_KEYS.add("sandwichToChathamDuration");
		THE_DURATION_KEYS.add("sandwichToBarnstableDuration");
		THE_DURATION_KEYS.add("sandwichToHyannisDuration");
		THE_DURATION_KEYS.add("sandwichToFalmouthDuration");
		// falmouth duration keys
		THE_DURATION_KEYS.add("falmouthToProvincetownDuration");
		THE_DURATION_KEYS.add("falmouthToTruroDuration");
		THE_DURATION_KEYS.add("falmouthToOrleansDuration");
		THE_DURATION_KEYS.add("falmouthToChathamDuration");
		THE_DURATION_KEYS.add("falmouthToBarnstableDuration");
		THE_DURATION_KEYS.add("falmouthToHyannisDuration");
		THE_DURATION_KEYS.add("falmouthToSandwichDuration");
		
		
		// prov distance keys
		THE_DISTANCE_KEYS.add("provincetownToTruroDistance");
		THE_DISTANCE_KEYS.add("provincetownToOrleansDistance");
		THE_DISTANCE_KEYS.add("provincetownToChathamDistance");
		THE_DISTANCE_KEYS.add("provincetownToBarnstableDistance");
		THE_DISTANCE_KEYS.add("provincetownToHyannisDistance");
		THE_DISTANCE_KEYS.add("provincetownToSandwichDistance");
		THE_DISTANCE_KEYS.add("provincetownToFalmouthDistance");
		// truro distance keys
		THE_DISTANCE_KEYS.add("truroToProvincetownDistance");
		THE_DISTANCE_KEYS.add("truroToOrleansDistance");
		THE_DISTANCE_KEYS.add("truroToChathamDistance");
		THE_DISTANCE_KEYS.add("truroToBarnstableDistance");
		THE_DISTANCE_KEYS.add("truroToHyannisDistance");
		THE_DISTANCE_KEYS.add("truroToSandwichDistance");
		THE_DISTANCE_KEYS.add("truroToFalmouthDistance");
		// orleans distance keys
		THE_DISTANCE_KEYS.add("orleansToProvincetownDistance");
		THE_DISTANCE_KEYS.add("orleansToTruroDistance");
		THE_DISTANCE_KEYS.add("orleansToChathamDistance");
		THE_DISTANCE_KEYS.add("orleansToBarnstableDistance");
		THE_DISTANCE_KEYS.add("orleansToHyannisDistance");
		THE_DISTANCE_KEYS.add("orleansToSandwichDistance");
		THE_DISTANCE_KEYS.add("orleansToFalmouthDistance");
		// chatham duration keys
		THE_DISTANCE_KEYS.add("chathamToProvincetownDistance");
		THE_DISTANCE_KEYS.add("chathamToTruroDistance");
		THE_DISTANCE_KEYS.add("chathamToOrleansDistance");
		THE_DISTANCE_KEYS.add("chathamToBarnstableDistance");
		THE_DISTANCE_KEYS.add("chathamToHyannisDistance");
		THE_DISTANCE_KEYS.add("chathamToSandwichDistance");
		THE_DISTANCE_KEYS.add("chathamToFalmouthDistance");
		// barnstable duration keys
		THE_DISTANCE_KEYS.add("barnstableToProvincetownDistance");
		THE_DISTANCE_KEYS.add("barnstableToTruroDistance");
		THE_DISTANCE_KEYS.add("barnstableToOrleansDistance");
		THE_DISTANCE_KEYS.add("barnstableToChathamDistance");
		THE_DISTANCE_KEYS.add("barnstableToHyannisDistance");
		THE_DISTANCE_KEYS.add("barnstableToSandwichDistance");
		THE_DISTANCE_KEYS.add("barnstableToFalmouthDistance");
		// hyannis duration keys
		THE_DISTANCE_KEYS.add("hyannisToProvincetownDistance");
		THE_DISTANCE_KEYS.add("hyannisToTruroDistance");
		THE_DISTANCE_KEYS.add("hyannisToOrleansDistance");
		THE_DISTANCE_KEYS.add("hyannisToChathamDistance");
		THE_DISTANCE_KEYS.add("hyannisToBarnstableDistance");
		THE_DISTANCE_KEYS.add("hyannisToSandwichDistance");
		THE_DISTANCE_KEYS.add("hyannisToFalmouthDistance");
		// sandwich duration keys
		THE_DISTANCE_KEYS.add("sandwichToProvincetownDistance");
		THE_DISTANCE_KEYS.add("sandwichToTruroDistance");
		THE_DISTANCE_KEYS.add("sandwichToOrleansDistance");
		THE_DISTANCE_KEYS.add("sandwichToChathamDistance");
		THE_DISTANCE_KEYS.add("sandwichToBarnstableDistance");
		THE_DISTANCE_KEYS.add("sandwichToHyannisDistance");
		THE_DISTANCE_KEYS.add("sandwichToFalmouthDistance");
		// falmouth duration keys
		THE_DISTANCE_KEYS.add("falmouthToProvincetownDistance");
		THE_DISTANCE_KEYS.add("falmouthToTruroDistance");
		THE_DISTANCE_KEYS.add("falmouthToOrleansDistance");
		THE_DISTANCE_KEYS.add("falmouthToChathamDistance");
		THE_DISTANCE_KEYS.add("falmouthToBarnstableDistance");
		THE_DISTANCE_KEYS.add("falmouthToHyannisDistance");
		THE_DISTANCE_KEYS.add("falmouthToSandwichDistance");
		
		for(String theKey : THE_DIRECTION_KEYS) {
			theDirections.put(theKey, new LinkedList<>());
		}
		
		for(String theKey : THE_DURATION_KEYS) {
			theDurations.put(theKey, new LinkedList<>());
		}
		
		for(String theKey : THE_DISTANCE_KEYS) {
			theDistances.put(theKey, new LinkedList<>());
		}
	} // end constructor
	
	private static class CapeCodHashMapHelper {
		private static final CapeCodHashMap theMap = new CapeCodHashMap();
	}
	
	public static Map<String, LinkedList<String>> getDirectionsMap() {
		return CapeCodHashMapHelper.theMap.theDirections;
	}
	
	public static Map<String, LinkedList<Integer>> getDurationsMap() {
		return CapeCodHashMapHelper.theMap.theDurations;
	}
	
	public static Map<String, LinkedList<Double>> getDistancesMap() {
		return CapeCodHashMapHelper.theMap.theDistances;
	}

}
