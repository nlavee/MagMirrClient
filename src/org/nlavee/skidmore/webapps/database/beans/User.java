package org.nlavee.skidmore.webapps.database.beans;

/*
 * User bean
 */

public class User {
	
	public String userName;
	public String password;
	public String firstName;
	
	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password
				+ ", firstName=" + firstName + "]";
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public User(String userName, String password, String firstName) {
		super();
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
	}

	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
