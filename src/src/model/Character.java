package model;

import java.io.Serializable;

public class Character implements Serializable {

	private String cname;
	private int point;
	public Character(String cname, int point) {
		super();
		this.cname = cname;
		this.point = point;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}


}
