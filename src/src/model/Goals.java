package model;

import java.io.Serializable;


public class Goals implements Serializable{
	private int ggoals;
	private	int gavailable;
	private int glimit;
	private String gwant;

	public Goals(int ggoals, int gavailable, int glimit, String gwant) {
		super();
		this.ggoals = ggoals;
		this.gavailable = gavailable;
		this.glimit = glimit;
		this.gwant = gwant;
	}

	public int getGgoals() {
		return ggoals;
	}

	public void setGgoals(int ggoals) {
		this.ggoals = ggoals;
	}

	public int getGavailable() {
		return gavailable;
	}

	public void setGavailable(int gavailable) {
		this.gavailable = gavailable;
	}

	public int getGlimit() {
		return glimit;
	}

	public void setGlimit(int glimit) {
		this.glimit = glimit;
	}

	public String getGwant() {
		return gwant;
	}

	public void setGwant(String gwant) {
		this.gwant = gwant;
	}













}
