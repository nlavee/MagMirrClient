package org.nlavee.skidmore.webapps.database.interfaces.impl;

import java.util.ArrayList;

import org.nlavee.skidmore.webapps.database.dao.ObjMapping;
import org.nlavee.skidmore.webapps.database.interfaces.NewsDBInterface;

public class NewsDBInterfaceImpl implements NewsDBInterface {

	@Override
	public boolean saveSection(String section, String username) {
		ObjMapping um = new ObjMapping();
		um.saveNewsSection(section, username);
		return true;
	}

	@Override
	public ArrayList<String> getNewsTopic(String username) {
		ObjMapping um = new ObjMapping();
		return um.getSection(username);
	}

}
