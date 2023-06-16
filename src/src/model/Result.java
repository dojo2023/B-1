package model;

import java.io.Serializable;

public class Result implements Serializable{
	private String title;
	private String backTo;


	public Result(String title, String backTo) {
		super();
		this.title = title;
		this.backTo = backTo;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getBackTo() {
		return backTo;
	}


	public void setBackTo(String backTo) {
		this.backTo = backTo;
	}

}
