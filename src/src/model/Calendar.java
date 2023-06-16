package model;

import java.io.Serializable;

public class Calendar implements Serializable {

	private String day;
	private int payment;

	public Calendar(String day, int payment) {
		super();
		this.day = day;
		this.payment = payment;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public int getPayment() {
		return payment;
	}
	public void setPayment(int payment) {
		this.payment = payment;
	}

}
