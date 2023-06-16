package achievement;

import java.io.Serializable;

public class achievement implements Serializable{
	private int bbank;
	private int ggoal;
	private int  paymony;
	private int  pointpm;

	public achievement(int bbank, int ggoal, int paymony, int pointpm) {
		super();
		this.bbank = bbank;
		this.ggoal = ggoal;
		this.paymony = paymony;
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

	public int getPaymony() {
		return paymony;
	}

	public void setPaymony(int paymony) {
		this.paymony = paymony;
	}

	public int getPointpm() {
		return pointpm;
	}

	public void setPointpm(int pointpm) {
		this.pointpm = pointpm;
	}

}
