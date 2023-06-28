package model;

import java.io.Serializable;


public class Ranking implements Serializable{
	private String userid;
	private String username;
	private int point;
	private String pic;

	public Ranking(String username, int point, String pic,String userid) {
		super();
		this.username = username;
		this.point = point;
		this.pic = pic;
		this.userid = userid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}

	public Ranking(String username, int point,String userid) {
		super();
		this.username = username;
		this.point = point;
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}


}