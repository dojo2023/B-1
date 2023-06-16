package model;

import java.io.Serializable;

public class Room implements Serializable{

	private String cname;
	private int ratio;
	private int meet;
	private String chealth;
	private int point;

	public Room(String cname, int ratio, int meet, String chealth, int point) {
		super();
		this.cname = cname;
		this.ratio = ratio;
		this.meet = meet;
		this.chealth = chealth;
		this.point = point;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public int getRatio() {
		return ratio;
	}

	public void setRatio(int ratio) {
		this.ratio = ratio;
	}

	public int getMeet() {
		return meet;
	}

	public void setMeet(int meet) {
		this.meet = meet;
	}

	public String getChealth() {
		return chealth;
	}

	public void setChealth(String chealth) {
		this.chealth = chealth;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}



}
