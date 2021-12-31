package com.felix.CapeCodRoadMap.directions;

import com.google.maps.GeoApiContext;

public final class TheGeoApiContext {
	
	private GeoApiContext theContext;
	
	private TheGeoApiContext() {
		theContext = new GeoApiContext.Builder().apiKey("google-api-key").build();
	}
	
	private static final class GeoApiContextHelper {
		private static final TheGeoApiContext GEO_API_CONTEXT = new TheGeoApiContext();
	}
	
	public static GeoApiContext getGeoApiContext() {
		return GeoApiContextHelper.GEO_API_CONTEXT.theContext;
	}

}
