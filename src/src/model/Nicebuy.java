package model;

import java.io.Serializable;

public class Nicebuy implements Serializable{

	private String buyte_id;
	private String buyte_count;

	// コンストラクタを生成
	public Nicebuy(String buyte_id) {
		super();
		this.buyte_id = buyte_id;
		this.buyte_count = "";
	}

	public String getBuyte_id() {
		return buyte_id;
	}
	public void setBuyte_id(String buyte_id) {
		this.buyte_id = buyte_id;
	}

	public String getBuyte_count() {
		return buyte_count;
	}
	public void setBuyte_count(String buyte_count) {
		this.buyte_count = buyte_count;
	}

}
