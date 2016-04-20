package org.nlavee.skidmore.webapps.web.config;

import org.nlavee.skidmore.webapps.database.interfaces.ConfigurationProperty;

public class MagMirrProperties implements ConfigurationProperty {

	static MagMirrProperties prop = null;

	private MagMirrProperties()
	{

	}

	public static MagMirrProperties getInstance()
	{
		if(prop == null)
		{
			prop = new MagMirrProperties();
		}

		return prop;
	}

	public String getValue(String name) {

		if(name.equals("driver"))
		{
			return DATABASE_DRIVER;
		}
		else if(name.equals("url"))
		{
			return DATABASE_URL;
		}
		else if(name.equals("userID"))
		{
			return DATABASE_USERID;
		}
		else if(name.equals("dbPassword"))
		{
			return DATABASE_PASSWORD;
		}
		else
		{
			return null;
		}
	}
}
