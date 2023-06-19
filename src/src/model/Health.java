package model;

import java.io.Serializable;

public class Health implements Serializable{
	private int chealth;

	public Health(int chealth) {
		super();
		this.chealth = chealth;
	}

	public int getChealth() {
		return chealth;
	}

	public void setChealth(int chealth) {
		this.chealth = chealth;
	}


}
