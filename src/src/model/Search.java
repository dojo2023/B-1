package model;

import java.io.Serializable;

public class Search implements Serializable{

	private String id;
	private String user_id;
	private String b_comment;
	private String s_history;

	// コンストラクタを生成
	public Search(String id, String user_id, String b_comment, String s_history) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.b_comment = b_comment;
		this.s_history = s_history;
	}

	// 検索用のコンストラクタも生成
	public Search(String user_id) {
		super();
		this.id = "";
		this.user_id = user_id;
		this.b_comment = "";
		this.s_history = "";
	}


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

	public String getS_history() {
		return s_history;
	}

	public void setS_history(String s_history) {
		this.s_history = s_history;
	}

}
