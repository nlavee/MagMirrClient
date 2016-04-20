package org.nlavee.skidmore.webapps.web.api.impl;

import org.json.JSONObject;
import org.nlavee.skidmore.webapps.web.api.ConnectorInterface;

public class ConnectorWrapper implements ConnectorInterface{

	@Override
	public boolean forwardMessage(String text) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean forwardTemperature(JSONObject weatherObject) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean forwardNews(String[] newsSelection) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean forwardLyftRideType(JSONObject rideTypeObject) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean forwardLyftETA(JSONObject ETAObject) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean forwardLyftCost(JSONObject costObject) {
		// TODO Auto-generated method stub
		return false;
	}

}
