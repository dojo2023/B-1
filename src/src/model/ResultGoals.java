package model;

import java.io.Serializable;

public class ResultGoals implements Serializable{
	private String message;
	private String pic;
	public ResultGoals(String message, String pic) {
		super();
		this.message = message;
		this.pic = pic;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}


}
