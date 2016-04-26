package org.nlavee.skidmore.webapps.database.interfaces;

import org.json.JSONObject;

public interface LyftDBInterface {

	public boolean persistRideType(JSONObject lyftObject, String userName);
	public boolean persistETA(JSONObject lyftObject, String userName);
	public boolean persistCostEstimate(JSONObject lyftObject, String userName);
}
