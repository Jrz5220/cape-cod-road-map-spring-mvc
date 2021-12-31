package com.felix.CapeCodRoadMap.directions;

import java.util.LinkedList;

public interface CapeCodDirectionsInterface {
	
	/**
	 * Get directions to Provincetown from a specified origin point. The origin should be a town in CapeCodRoadMap.
	 * If not, a value of null is returned.
	 * @param origin The starting point for the directions. Should be a town in CapeCodRoadMap.
	 * @return a list containing the directions to Provincetown from the specified origin point, or null if the origin point is not a town in CapeCodRoadMap.
	 */
	public LinkedList<String> getDirectionsToProvincetown(String origin);
	
	/**
	 * Get the estimated time (in minutes) required to reach Provincetown from a specified origin point using the calculated directions.
	 * The origin should be a town in CapeCodRoadMap. If not, or if origin and destination are the same, a value of 0 is returned.
	 * @param origin The starting point for the directions. Should be a town in CapeCodRoadMap.
	 * @return the duration (in minutes) to reach Provincetown from the specified origin point.
	 */
	public int getDurationToProvincetown(String origin);
	
	/**
	 * Get the estimated distance (in miles) to reach Provincetown from a specified origin point using the calculated directions.
	 * The origin should be a town in CapeCodRoadMap. If not, or if origin and destination are the same, a value of 0.0 is returned.
	 * @param origin The starting point for the directions. Should be a town in CapeCodRoadMap.
	 * @return the distance (in miles) to reach Provincetown from the specified origin point.
	 */
	public double getDistanceToProvincetown(String origin);
	
	/**
	 * Get directions to Truro from a specified origin point. The origin should be a town in CapeCodRoadMap.
	 * If not, a value of null is returned.
	 * @param origin The starting point for the directions. Should be a town in CapeCodRoadMap.
	 * @return a list containing the directions to Truro from the specified origin point, or null if the origin point is not a town in CapeCodRoadMap.
	 */
	public LinkedList<String> getDirectionsToTruro(String origin);
	
	/**
	 * Get the estimated time (in minutes) required to reach Truro from a specified origin point using the calculated directions.
	 * The origin should be a town in CapeCodRoadMap. If not, or if origin and destination are the same, a value of 0 is returned.
	 * @param origin The starting point for the directions. Should be a town in CapeCodRoadMap.
	 * @return the duration (in minutes) to reach Truro from the specified origin point.
	 */
	public int getDurationToTruro(String origin);
	
	/**
	 * Get the estimated distance (in miles) to reach Truro from a specified origin point using the calculated directions.
	 * The origin should be a town in CapeCodRoadMap. If not, or if origin and destination are the same, a value of 0.0 is returned.
	 * @param origin The starting point for the directions. Should be a town in CapeCodRoadMap.
	 * @return the distance (in miles) to reach Truro from the specified origin point.
	 */
	public double getDistanceToTruro(String origin);
	
	/**
	 * Get directions to Orleans from a specified origin point. The origin should be a town in CapeCodRoadMap.
	 * If not, a value of null is returned.
	 * @param origin The starting point for the directions. Should be a town in CapeCodRoadMap.
	 * @return a list containing the directions to Orleans from the specified origin point, or null if the origin point is not a town in CapeCodRoadMap.
	 */
	public LinkedList<String> getDirectionsToOrleans(String origin);
	
	/**
	 * Get the estimated time (in minutes) required to reach Orleans from a specified origin point using the calculated directions.
	 * The origin should be a town in CapeCodRoadMap. If not, or if origin and destination are the same, a value of 0 is returned.
	 * @param origin The starting point for the directions. Should be a town in CapeCodRoadMap.
	 * @return the duration (in minutes) to reach Orleans from the specified origin point.
	 */
	public int getDurationToOrleans(String origin);
	
	/**
	 * Get the estimated distance (in miles) to reach Orleans from a specified origin point using the calculated directions.
	 * The origin should be a town in CapeCodRoadMap. If not, or if origin and destination are the same, a value of 0.0 is returned.
	 * @param origin The starting point for the directions. Should be a town in CapeCodRoadMap.
	 * @return the distance (in miles) to reach Orleans from the specified origin point.
	 */
	public double getDistanceToOrleans(String origin);
	
	/**
	 * Get directions to Chatham from a specified origin point. The origin should be a town in CapeCodRoadMap.
	 * If not, a value of null is returned.
	 * @param origin The starting point for the directions. Should be a town in CapeCodRoadMap.
	 * @return a list containing the directions to Chatham from the specified origin point, or null if the origin point is not a town in CapeCodRoadMap.
	 */
	public LinkedList<String> getDirectionsToChatham(String origin);
	
	/**
	 * Get the estimated time (in minutes) required to reach Chatham from a specified origin point using the calculated directions.
	 * The origin should be a town in CapeCodRoadMap. If not, or if origin and destination are the same, a value of 0 is returned.
	 * @param origin The starting point for the directions. Should be a town in CapeCodRoadMap.
	 * @return the duration (in minutes) to reach Chatham from the specified origin point.
	 */
	public int getDurationToChatham(String origin);
	
	/**
	 * Get the estimated distance (in miles) to reach Chatham from a specified origin point using the calculated directions.
	 * The origin should be a town in CapeCodRoadMap. If not, or if origin and destination are the same, a value of 0.0 is returned.
	 * @param origin The starting point for the directions. Should be a town in CapeCodRoadMap.
	 * @return the distance (in miles) to reach Chatham from the specified origin point.
	 */
	public double getDistanceToChatham(String origin);
	
	/**
	 * Get directions to Barnstable from a specified origin point. The origin should be a town in CapeCodRoadMap.
	 * If not, a value of null is returned.
	 * @param origin The starting point for the directions. Should be a town in CapeCodRoadMap.
	 * @return a list containing the directions to Barnstable from the specified origin point, or null if the origin point is not a town in CapeCodRoadMap.
	 */
	public LinkedList<String> getDirectionsToBarnstable(String origin);
	
	/**
	 * Get the estimated time (in minutes) required to reach Barnstable from a specified origin point using the calculated directions.
	 * The origin should be a town in CapeCodRoadMap. If not, or if origin and destination are the same, a value of 0 is returned.
	 * @param origin The starting point for the directions. Should be a town in CapeCodRoadMap.
	 * @return the duration (in minutes) to reach Barnstable from the specified origin point.
	 */
	public int getDurationToBarnstable(String origin);
	
	/**
	 * Get the estimated distance (in miles) to reach Barnstable from a specified origin point using the calculated directions.
	 * The origin should be a town in CapeCodRoadMap. If not, or if origin and destination are the same, a value of 0.0 is returned.
	 * @param origin The starting point for the directions. Should be a town in CapeCodRoadMap.
	 * @return the distance (in miles) to reach Barnstable from the specified origin point.
	 */
	public double getDistanceToBarnstable(String origin);
	
	/**
	 * Get directions to Hyannis from a specified origin point. The origin should be a town in CapeCodRoadMap.
	 * If not, a value of null is returned.
	 * @param origin The starting point for the directions. Should be a town in CapeCodRoadMap.
	 * @return a list containing the directions to Hyannis from the specified origin point, or null if the origin point is not a town in CapeCodRoadMap.
	 */
	public LinkedList<String> getDirectionsToHyannis(String origin);
	
	/**
	 * Get the estimated time (in minutes) required to reach Hyannis from a specified origin point using the calculated directions.
	 * The origin should be a town in CapeCodRoadMap. If not, or if origin and destination are the same, a value of 0 is returned.
	 * @param origin The starting point for the directions. Should be a town in CapeCodRoadMap.
	 * @return the duration (in minutes) to reach Hyannis from the specified origin point.
	 */
	public int getDurationToHyannis(String origin);
	
	/**
	 * Get the estimated distance (in miles) to reach Hyannis from a specified origin point using the calculated directions.
	 * The origin should be a town in CapeCodRoadMap. If not, or if origin and destination are the same, a value of 0.0 is returned.
	 * @param origin The starting point for the directions. Should be a town in CapeCodRoadMap.
	 * @return the distance (in miles) to reach Hyannis from the specified origin point.
	 */
	public double getDistanceToHyannis(String origin);
	
	/**
	 * Get directions to Sandwich from a specified origin point. The origin should be a town in CapeCodRoadMap.
	 * If not, a value of null is returned.
	 * @param origin The starting point for the directions. Should be a town in CapeCodRoadMap.
	 * @return a list containing the directions to Sandwich from the specified origin point, or null if the origin point is not a town in CapeCodRoadMap.
	 */
	public LinkedList<String> getDirectionsToSandwich(String origin);
	
	/**
	 * Get the estimated time (in minutes) required to reach Sandwich from a specified origin point using the calculated directions.
	 * The origin should be a town in CapeCodRoadMap. If not, or if origin and destination are the same, a value of 0 is returned.
	 * @param origin The starting point for the directions. Should be a town in CapeCodRoadMap.
	 * @return the duration (in minutes) to reach Sandwich from the specified origin point.
	 */
	public int getDurationToSandwich(String origin);
	
	/**
	 * Get the estimated distance (in miles) to reach Sandwich from a specified origin point using the calculated directions.
	 * The origin should be a town in CapeCodRoadMap. If not, or if origin and destination are the same, a value of 0.0 is returned.
	 * @param origin The starting point for the directions. Should be a town in CapeCodRoadMap.
	 * @return the distance (in miles) to reach Sandwich from the specified origin point.
	 */
	public double getDistanceToSandwich(String origin);
	
	/**
	 * Get directions to Falmouth from a specified origin point. The origin should be a town in CapeCodRoadMap.
	 * If not, a value of null is returned.
	 * @param origin The starting point for the directions. Should be a town in CapeCodRoadMap.
	 * @return a list containing the directions to Falmouth from the specified origin point, or null if the origin point is not a town in CapeCodRoadMap.
	 */
	public LinkedList<String> getDirectionsToFalmouth(String origin);
	
	/**
	 * Get the estimated time (in minutes) required to reach Falmouth from a specified origin point using the calculated directions.
	 * The origin should be a town in CapeCodRoadMap. If not, or if origin and destination are the same, a value of 0 is returned.
	 * @param origin The starting point for the directions. Should be a town in CapeCodRoadMap.
	 * @return the duration (in minutes) to reach Falmouth from the specified origin point.
	 */
	public int getDurationToFalmouth(String origin);
	
	/**
	 * Get the estimated distance (in miles) to reach Falmouth from a specified origin point using the calculated directions.
	 * The origin should be a town in CapeCodRoadMap. If not, or if origin and destination are the same, a value of 0.0 is returned.
	 * @param origin The starting point for the directions. Should be a town in CapeCodRoadMap.
	 * @return the distance (in miles) to reach Falmouth from the specified origin point.
	 */
	public double getDistanceToFalmouth(String origin);

}
