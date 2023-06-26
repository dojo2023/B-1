package model;

import java.io.Serializable;

public class SetGoals implements Serializable{
	private int ggoals;
	private String glimit;
	private String gwant;
	private String cname;
	private String userid;
	private int gavailable;
	public SetGoals(int ggoals, String glimit, String gwant,String cname, String userid,
			int gavailable) {
		super();
		this.ggoals = ggoals;
		this.glimit = glimit;
		this.gwant = gwant;
		this.cname = cname;
		this.userid = userid;
		this.gavailable = gavailable;
	}
	public int getGgoals() {
		return ggoals;
	}
	public void setGgoals(int ggoals) {
		this.ggoals = ggoals;
	}
	public String getGlimit() {
		return glimit;
	}
	public void setGlimit(String glimit) {
		this.glimit = glimit;
	}
	public String getGwant() {
		return gwant;
	}
	public void setGwant(String gwant) {
		this.gwant = gwant;
	}
//	public String getGwantpic() {
//		return gwantpic;
//	}
//	public void setGwantpic(String gwantpic) {
//		this.gwantpic = gwantpic;
//	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public int getGavailable() {
		return gavailable;
	}
	public void setGavailable(int gavailable) {
		this.gavailable = gavailable;
	}

}
