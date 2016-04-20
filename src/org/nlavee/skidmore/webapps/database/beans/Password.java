package org.nlavee.skidmore.webapps.database.beans;

public class Password {

	private String pwdHash;
	private String salt;
	
	public Password(String pwdHash, String salt) {
		this.pwdHash = pwdHash;
		this.salt = salt;
	}

	public String getPwdHash() {
		return pwdHash;
	}

	public void setPwdHash(String pwdHash) {
		this.pwdHash = pwdHash;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	@Override
	public String toString() {
		return "Password [pwdHash=" + pwdHash + ", salt=" + salt + "]";
	}
	 
	
}
