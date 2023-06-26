package model;

import java.io.Serializable;

public class CalendarDate implements Serializable{

	private String gwant;
	private int until;
	private String charpic;
	private String backpic;
	private int bbank;
	private int ggoals;

	public CalendarDate(String gwant, int until, String charpic, String backpic, int bbank, int ggoals) {
		super();
		this.gwant = gwant;
		this.until = until;
		this.charpic = charpic;
		this.backpic = backpic;
		this.bbank = bbank;
		this.ggoals = ggoals;
	}
	public String getGwant() {
		return gwant;
	}
	public void setGwant(String gwant) {
		this.gwant = gwant;
	}
	public int getUntil() {
		return until;
	}
	public void setUntil(int until) {
		this.until = until;
	}
	public String getBackpic() {
		return backpic;
	}
	public void setBackpic(String backpic) {
		this.backpic = backpic;
	}
	public String getCharpic() {
		return charpic;
	}
	public void setCharpic(String charpic) {
		this.charpic = charpic;
	}
	public int getBbank() {
		return bbank;
	}
	public void setBbank(int bbank) {
		this.bbank = bbank;
	}
	public int getGgoals() {
		return ggoals;
	}
	public void setGgoals(int ggoals) {
		this.ggoals = ggoals;
	}




}
