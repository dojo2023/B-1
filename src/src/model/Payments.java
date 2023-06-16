package model;

import java.io.Serializable;

public class Payments implements Serializable{

	private String paycategory;
	private int paymoney;

	public Payments(String paycategory, int paymoney) {
		super();
		this.paycategory = paycategory;
		this.paymoney = paymoney;
	}

	public String getPaycategory() {
		return paycategory;
	}

	public void setPaycategory(String paycategory) {
		this.paycategory = paycategory;
	}

	public int getPaymoney() {
		return paymoney;
	}

	public void setPaymoney(int paymoney) {
		this.paymoney = paymoney;
	}


}
