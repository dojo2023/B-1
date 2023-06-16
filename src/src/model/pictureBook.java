package model;

import java.io.Serializable;

public class PictureBook implements Serializable{
	private String charpic;
	private int charid;
	public PictureBook(String charpic, int charid) {
		super();
		this.charpic = charpic;
		this.charid = charid;
	}
	public String getCharpic() {
		return charpic;
	}
	public void setCharpic(String charpic) {
		this.charpic = charpic;
	}
	public int getCharid() {
		return charid;
	}
	public void setCharid(int charid) {
		this.charid = charid;
	}


}
