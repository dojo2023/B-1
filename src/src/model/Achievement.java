package model;

import java.io.Serializable;

public class Achievement implements Serializable{
	private int bbank;
	private int ggoal;
	private int paymoney;
	private int pointpm;
	public Achievement(int bbank, int ggoal, int paymoney, int pointpm) {
		super();
		this.bbank = bbank;
		this.ggoal = ggoal;
		this.paymoney = paymoney;
		this.pointpm = pointpm;
	}
	public int getBbank() {
		return bbank;
	}
	public void setBbank(int bbank) {
		this.bbank = bbank;
	}
	public int getGgoal() {
		return ggoal;
	}
	public void setGgoal(int ggoal) {
		this.ggoal = ggoal;
	}
	public int getPaymoney() {
		return paymoney;
	}
	public void setPaymoney(int paymoney) {
		this.paymoney = paymoney;
	}
	public int getPointpm() {
		return pointpm;
	}
	public void setPointpm(int pointpm) {
		this.pointpm = pointpm;
	}


}
