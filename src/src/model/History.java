package model;

import java.io.Serializable;

public class History implements Serializable{
	private String shistory;

	public History(String shistory) {
		super();
		this.shistory = shistory;
	}

	public String getShistory() {
		return shistory;
	}

	public void setShistory(String shistory) {
		this.shistory = shistory;
	}
}
