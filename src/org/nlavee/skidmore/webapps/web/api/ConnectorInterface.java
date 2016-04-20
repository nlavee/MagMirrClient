package org.nlavee.skidmore.webapps.web.api;

import org.json.JSONObject;

public interface ConnectorInterface {
	
	/**
	 * Method to forward message that user typed to the rest end point
	 * @param text
	 * @return
	 */
	public boolean forwardMessage(String text);
	
	/**
	 * Method to forward temperature selection to the rest end point
	 * @param weatherObject
	 * @return
	 */
	public boolean forwardTemperature(JSONObject weatherObject);
	
	/**
	 * Method to forward news selection to the rest end point
	 * @param newsObject
	 * @return
	 */
	public boolean forwardNews(String[] selectedTopics);
	
	/**
	 * Method to forward Lyft Ride Type to the rest end point
	 * @param rideTypeObject
	 * @return
	 */
	public boolean forwardLyftRideType(JSONObject rideTypeObject);
	
	/**
	 * Method to forward Lyft ETA to the rest end point
	 * @param ETAObject
	 * @return
	 */
	public boolean forwardLyftETA(JSONObject ETAObject);
	
	/**
	 * Method to forward Lyft cost to the rest end point
	 * @param costObject
	 * @return
	 */
	public boolean forwardLyftCost(JSONObject costObject);
}
