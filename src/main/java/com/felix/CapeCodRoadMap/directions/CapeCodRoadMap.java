package com.felix.CapeCodRoadMap.directions;

import com.felix.CapeCodRoadMap.graph.DirectedGraph;

public final class CapeCodRoadMap {
	
	protected static final String PROVINCETOWN = "provincetown";
	protected static final String HYANNIS = "hyannis";
	protected static final String TRURO = "truro";
	protected static final String ORLEANS = "orleans";
	protected static final String CHATHAM = "chatham";
	protected static final String BARNSTABLE = "barnstable";
	protected static final String SANDWICH = "sandwich";
	protected static final String FALMOUTH = "falmouth";
	
	private DirectedGraph<String> theRoadMap;
	private String[] theTowns;
	
	private CapeCodRoadMap() {
		theRoadMap = new DirectedGraph<>();
	    addTownsToCapeCod(PROVINCETOWN, HYANNIS, TRURO, ORLEANS, CHATHAM, BARNSTABLE, SANDWICH, FALMOUTH);
		createRoadMap();
	}
	
	private void addTownsToCapeCod(String... towns) {
		theTowns = new String[towns.length];
		for(int i = 0; i < theTowns.length; i++) {
			theTowns[i] = towns[i];
		}
	}
	
	private void createRoadMap() {
	    // add towns to graph
		for(String town : theTowns) {
			theRoadMap.addVertex(town);
		}
	    // connect towns
	    theRoadMap.addEdge(PROVINCETOWN, TRURO, 10);
	    theRoadMap.addEdge(TRURO, PROVINCETOWN, 10);
	    theRoadMap.addEdge(TRURO, ORLEANS, 17);
	    theRoadMap.addEdge(ORLEANS, TRURO, 17);
	    theRoadMap.addEdge(ORLEANS, CHATHAM, 9);
	    theRoadMap.addEdge(ORLEANS, BARNSTABLE, 19);
	    theRoadMap.addEdge(CHATHAM, ORLEANS, 9);
	    theRoadMap.addEdge(CHATHAM, HYANNIS, 19);
	    theRoadMap.addEdge(HYANNIS, CHATHAM, 19);
	    theRoadMap.addEdge(HYANNIS, BARNSTABLE, 4);
	    theRoadMap.addEdge(HYANNIS, FALMOUTH, 20);
	    theRoadMap.addEdge(BARNSTABLE, ORLEANS, 19);
	    theRoadMap.addEdge(BARNSTABLE, HYANNIS, 4);
	    theRoadMap.addEdge(BARNSTABLE, SANDWICH, 12);
	    theRoadMap.addEdge(SANDWICH, BARNSTABLE, 12);
	    theRoadMap.addEdge(FALMOUTH, HYANNIS, 20);
	}
	
	private static class RoadMapHelper {
		private static final CapeCodRoadMap CAPE_COD_ROAD_MAP = new CapeCodRoadMap();
	}
	
	/**
	 * Returns a DirectedGraph connecting all the towns in this cape cod road map.
	 * The towns are connected by weighted edges.
	 * @return the cape cod road map containing all routes
	 */
	public static DirectedGraph<String> getRoadMap() {
		return RoadMapHelper.CAPE_COD_ROAD_MAP.theRoadMap;
	}

	/**
	 * Returns a String array containing all the towns added to this road map of cape cod
	 * @return all the towns in the cape cod road map
	 */
	public static String[] getTowns() {
		return RoadMapHelper.CAPE_COD_ROAD_MAP.theTowns;
	}

}
