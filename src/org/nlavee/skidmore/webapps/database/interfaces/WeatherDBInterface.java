package org.nlavee.skidmore.webapps.database.interfaces;

public interface WeatherDBInterface {
	public boolean saveZipcode(Integer zipcode, String username);
	
	public Integer getWeather(Integer userId);
}
