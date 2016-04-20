package org.nlavee.skidmore.webapps.web.api;

import java.util.ArrayList;

import org.nlavee.skidmore.webapps.web.model.NewsObj;

public interface NewsInterface {

	/**
	 * Method that returns top news based on the section selected
	 * @param sections that are chosen by the users
	 * @return an arraylist of NewsObj.
	 */
	public ArrayList<NewsObj> chooseSections(String[] sections);
}
