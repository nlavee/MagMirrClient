package org.nlavee.skidmore.webapps.database.beans;

public class Message {

	private String body;
	private String time;
	
	public Message(String body, String time) {
		this.body = body;
		this.time = time;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "Message [body=" + body + ", time=" + time + "]";
	}
	
	
}
