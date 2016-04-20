package org.nlavee.skidmore.webapps.web.api;

import org.json.JSONObject;

public interface WeatherInterface {

	public JSONObject getWeather(Integer zipcode);
}
