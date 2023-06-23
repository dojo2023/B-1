package model;

import java.io.Serializable;


public class Goals implements Serializable{
	private int ggoals;
	private	int gavailable;
	private String glimit;
	private String gwant;

	public Goals(int ggoals, int gavailable, String glimit, String gwant) {
		super();
		this.ggoals = ggoals;
		this.gavailable = gavailable;
		this.glimit = glimit;
		this.gwant = gwant;
	}

	public int getGoals() {
		return ggoals;
	}

	public void setGoals(int ggoals) {
		this.ggoals = ggoals;
	}

	public int getGavailable() {
		return gavailable;
	}

	public void setGavailable(int gavailable) {
		this.gavailable = gavailable;
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













}
