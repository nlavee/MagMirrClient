package org.nlavee.skidmore.webapps.database.interfaces;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.Date;

import org.nlavee.skidmore.webapps.database.beans.NewUser;
import org.nlavee.skidmore.webapps.database.beans.User;

public interface UserInterface {

	public boolean AuthenticateUser(User user) throws NoSuchAlgorithmException, NoSuchProviderException;
	public User RegisterUser(NewUser user) throws NoSuchAlgorithmException, NoSuchProviderException, IllegalStateException;
	public boolean saveMessage(String body, Date date);
	public String getFirstName(String userName);
}
