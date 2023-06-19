package model;

import java.io.Serializable;

public class Buytters implements Serializable{

	private String id;
	private String user_id;
	private String b_comment;
	private String b_pic;
	private String created_at;//もしかしたら、Date型かもわからん

	// コンストラクタを生成
	public Buytters(String id, String user_id, String b_comment, String b_pic, String created_at) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.b_comment = b_comment;
		this.b_pic = b_pic;
		this.created_at = created_at;
	}

//	// 引数のないコンストラクタも生成
//	public Buytters() {
//		super();
//		this.b_pic = "";
//	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getB_comment() {
		return b_comment;
	}

	public void setB_comment(String b_comment) {
		this.b_comment = b_comment;
	}

	public String getB_pic() {
		return b_pic;
	}

	public void setB_pic(String b_pic) {
		this.b_pic = b_pic;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

}
