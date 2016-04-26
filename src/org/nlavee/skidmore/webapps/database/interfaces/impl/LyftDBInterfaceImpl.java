package org.nlavee.skidmore.webapps.database.interfaces.impl;

import org.apache.commons.lang3.StringEscapeUtils;
import org.json.JSONObject;
import org.nlavee.skidmore.webapps.database.dao.ObjMapping;
import org.nlavee.skidmore.webapps.database.interfaces.LyftDBInterface;

public class LyftDBInterfaceImpl implements LyftDBInterface {

	@Override
	public boolean persistRideType(JSONObject lyftObject, String userName) {
		String toSave = StringEscapeUtils.escapeJson(lyftObject.toString());
		
		ObjMapping om = new ObjMapping();
		return om.persistLyftData(toSave, userName);
	}

	@Override
	public boolean persistETA(JSONObject lyftObject, String userName) {
		String toSave = StringEscapeUtils.escapeJson(lyftObject.toString());
		
		ObjMapping om = new ObjMapping();
		return om.persistLyftData(toSave, userName);
	}

	@Override
	public boolean persistCostEstimate(JSONObject lyftObject, String userName) {
		String toSave = StringEscapeUtils.escapeJson(lyftObject.toString());
		
		ObjMapping om = new ObjMapping();
		return om.persistLyftData(toSave, userName);
	}

}
