package model;

import java.io.Serializable;


public class Idpws implements Serializable{
	private String userid;
	private String userpw;
	private String username;

	public Idpws(String userid, String userpw, String username) {
		super();
		this.userid = userid;
		this.userpw = userpw;
		this.username = username;
	}

	public Idpws(String userid, String userpw) {
		super();
		this.userid = userid;
		this.userpw = userpw;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUserpw() {
		return userpw;
	}

	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}



}

