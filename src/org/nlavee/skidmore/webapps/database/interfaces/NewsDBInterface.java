package org.nlavee.skidmore.webapps.database.interfaces;

import java.util.ArrayList;

public interface NewsDBInterface {

	public boolean saveSection(String section, String username);
	public ArrayList<String> getNewsTopic(String username);
}
