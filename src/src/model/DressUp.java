package model;

import java.io.Serializable;

public class DressUp implements Serializable {

	private String itempic;
	private int itempoint;
	private int itembuy;

	public DressUp(String itempic, int itempoint, int itembuy) {
		super();
		this.itempic = itempic;
		this.itempoint = itempoint;
		this.itembuy = itembuy;
	}

	public String getItempic() {
		return itempic;
	}

	public void setItempic(String itempic) {
		this.itempic = itempic;
	}

	public int getItempoint() {
		return itempoint;
	}

	public void setItempoint(int itempoint) {
		this.itempoint = itempoint;
	}

	public int getItembuy() {
		return itembuy;
	}

	public void setItembuy(int itembuy) {
		this.itembuy = itembuy;
	}



}
