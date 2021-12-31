package com.felix.CapeCodRoadMap.controller;

import java.util.LinkedList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.felix.CapeCodRoadMap.directions.BarnstableDirections;
import com.felix.CapeCodRoadMap.directions.CapeCodDirections;
import com.felix.CapeCodRoadMap.directions.ChathamDirections;
import com.felix.CapeCodRoadMap.directions.FalmouthDirections;
import com.felix.CapeCodRoadMap.directions.HyannisDirections;
import com.felix.CapeCodRoadMap.directions.OrleansDirections;
import com.felix.CapeCodRoadMap.directions.ProvDirections;
import com.felix.CapeCodRoadMap.directions.SandwichDirections;
import com.felix.CapeCodRoadMap.directions.TruroDirections;

@Controller
public class CapeCodRoadMapController {
	
	private int theDuration;
	private double theDistance;
	private CapeCodDirections provDirections;
	private CapeCodDirections truroDirections;
	private CapeCodDirections orleansDirections;
	private CapeCodDirections chathamDirections;
	private CapeCodDirections barnstableDirections;
	private CapeCodDirections hyannisDirections;
	private CapeCodDirections sandwichDirections;
	private CapeCodDirections falmouthDirections;
	private LinkedList<String> theDirections;
	
	public CapeCodRoadMapController() {
		theDuration = 0;
		theDistance = 0;
		/* The directions are retrieved from Google's Directions API when constructing the following
		 * CapeCodDirections objects. This is required because the Directions API callback method that 
		 * retrieves the directions will only execute after all other actions in the request have completed.
		 * This means you have to load the directions before any requests have been made. */
		provDirections = new ProvDirections();
		truroDirections = new TruroDirections();
		orleansDirections = new OrleansDirections();
		chathamDirections = new ChathamDirections();
		barnstableDirections = new BarnstableDirections();
		hyannisDirections = new HyannisDirections();
		sandwichDirections = new SandwichDirections();
		falmouthDirections = new FalmouthDirections();
		theDirections = new LinkedList<>();
	}
	
	@GetMapping("/")
	public String homePage() {
		return "index";
	}
	
	@GetMapping("/getDirections")
	public final String capeCodDirections(@RequestParam("origin-town") String origin, @RequestParam("destination-town") String destination, Model theModel) {
		String capOrigin = "";
		String capDest = "";
		String directionTitle = "Not a valid route";
		if(origin == null)
			origin = "";
		if(destination == null)
			destination = "";
		if(origin.length() > 1 && destination.length() > 1) {
			capOrigin = origin.substring(0, 1).toUpperCase() + origin.substring(1).toLowerCase();
			capDest = destination.substring(0, 1).toUpperCase() + destination.substring(1).toLowerCase();
			directionTitle = capOrigin + " to " + capDest;
		}
		switch(origin) {
			case "provincetown":
				setDirectionsData(origin, destination, provDirections);
				break;
			case "truro":
				setDirectionsData(origin, destination, truroDirections);
				break;
			case "orleans":
				setDirectionsData(origin, destination, orleansDirections);
				break;
			case "chatham":
				setDirectionsData(origin, destination, chathamDirections);
				break;
			case "barnstable":
				setDirectionsData(origin, destination, barnstableDirections);
				break;
			case "hyannis":
				setDirectionsData(origin, destination, hyannisDirections);
				break;
			case "sandwich":
				setDirectionsData(origin, destination, sandwichDirections);
				break;
			case "falmouth":
				setDirectionsData(origin, destination, falmouthDirections);
				break;
			default:
				theDirections.clear();
				break;
		}
		if(theDirections == null) {
			theDirections = new LinkedList<>();
		}
		if(theDirections.isEmpty()) {
			theDirections.add("Could not get directions for this route");
		}
		theModel.addAttribute("result", true);
		theModel.addAttribute("directionTitle", directionTitle);
		theModel.addAttribute("tripDistance", theDistance);
		theModel.addAttribute("tripDuration", theDuration);
		theModel.addAttribute("directions", theDirections);
		return "index";
	}
	
	// set travel directions, duration, and distance
	private void setDirectionsData(String origin, String destination, CapeCodDirections originDirections) {
		switch(destination) {
			case "provincetown":
				theDirections = originDirections.getDirectionsToProvincetown(origin);
				theDuration = originDirections.getDurationToProvincetown(origin);
				theDistance = originDirections.getDistanceToProvincetown(origin);
				break;
			case "truro":
				theDirections = originDirections.getDirectionsToTruro(origin);
				theDuration = originDirections.getDurationToTruro(origin);
				theDistance = originDirections.getDistanceToTruro(origin);
				break;
			case "orleans":
				theDirections = originDirections.getDirectionsToOrleans(origin);
				theDuration = originDirections.getDurationToOrleans(origin);
				theDistance = originDirections.getDistanceToOrleans(origin);
				break;
			case "chatham":
				theDirections = originDirections.getDirectionsToChatham(origin);
				theDuration = originDirections.getDurationToChatham(origin);
				theDistance = originDirections.getDistanceToChatham(origin);
				break;
			case "barnstable":
				theDirections = originDirections.getDirectionsToBarnstable(origin);
				theDuration = originDirections.getDurationToBarnstable(origin);
				theDistance = originDirections.getDistanceToBarnstable(origin);
				break;
			case "hyannis":
				theDirections = originDirections.getDirectionsToHyannis(origin);
				theDuration = originDirections.getDurationToHyannis(origin);
				theDistance = originDirections.getDistanceToHyannis(origin);
				break;
			case "sandwich":
				theDirections = originDirections.getDirectionsToSandwich(origin);
				theDuration = originDirections.getDurationToSandwich(origin);
				theDistance = originDirections.getDistanceToSandwich(origin);
				break;
			case "falmouth":
				theDirections = originDirections.getDirectionsToFalmouth(origin);
				theDuration = originDirections.getDurationToFalmouth(origin);
				theDistance = originDirections.getDistanceToFalmouth(origin);
				break;
			default:
				theDirections.clear();
				break;
		}
	}

}
