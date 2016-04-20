package org.nlavee.skidmore.webapps.database.interfaces.impl;

import org.nlavee.skidmore.webapps.database.dao.ObjMapping;
import org.nlavee.skidmore.webapps.database.interfaces.WeatherDBInterface;

public class WeatherDBInterfaceImpl implements WeatherDBInterface{

	@Override
	public boolean saveZipcode(Integer zipcode, String username) {

		ObjMapping um = new ObjMapping();
		um.saveWeatherLocation(zipcode, username);
		return true;
	}

	@Override
	public Integer getWeather(Integer userId) {
		ObjMapping om = new ObjMapping();
		Integer zip = om.getWeather(userId);
		return zip;
	}

}
