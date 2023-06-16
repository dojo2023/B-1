package model;

import java.io.Serializable;

public class Buytters implements Serializable{

	private String userid;
	private String bcommnet;
	private String b_pic;
	private String createdat;//もしかしたら、Date型かもわからん

	public Buytters(String userid, String bcommnet, String b_pic, String createdat) {
		super();
		this.userid = userid;
		this.bcommnet = bcommnet;
		this.b_pic = b_pic;
		this.createdat = createdat;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getBcommnet() {
		return bcommnet;
	}

	public void setBcommnet(String bcommnet) {
		this.bcommnet = bcommnet;
	}

	public String getB_pic() {
		return b_pic;
	}

	public void setB_pic(String b_pic) {
		this.b_pic = b_pic;
	}

	public String getCreatedat() {
		return createdat;
	}

	public void setCreatedat(String createdat) {
		this.createdat = createdat;
	}

}
