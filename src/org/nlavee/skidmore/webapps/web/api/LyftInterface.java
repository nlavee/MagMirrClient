package org.nlavee.skidmore.webapps.web.api;

import org.json.JSONObject;
import org.nlavee.skidmore.webapps.database.beans.Coords;

public interface LyftInterface {
	
	/**
	 * Method to authenticate using OAuth2 for Lyft API
	 * @return JSONObject containing the authentication data
	 */
	public JSONObject authenticate();
	
	/**
	 * Method to get ride type for a specific coordinates
	 * @param coord
	 * @return
	 */
	public JSONObject getRideType(Coords coord, JSONObject accessTokenJSON);
	
	/**
	 * Method to get estimated arrival time of a driver to the coordinate given
	 * @param coord
	 * @param accessTokenJSON
	 * @return
	 */
	public JSONObject getETA(Coords coord, JSONObject accessTokenJSON);
	
	/**
	 * Method to get cost going from a point to another
	 * @param coordStart
	 * @param coordEnd
	 * @param accessTokenJSON
	 * @return
	 */
	public JSONObject getCost(Coords coordStart, Coords coordEnd, JSONObject accessTokenJSON);
	
	/**
	 * Method to get cost from a point to another with a specific ride type
	 * @param coordStart
	 * @param coordEnd
	 * @param rideType
	 * @param accessTokenJSON
	 * @return
	 */
	public JSONObject getCost(Coords coordStart, Coords coordEnd, String rideType, JSONObject accessTokenJSON);
}
