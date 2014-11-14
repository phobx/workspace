package com.webcamp.dto;

import java.io.Serializable;

public class Player implements Serializable{

	private static final long serialVersionUID = 1L;

	private String name;
	private int coins;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCoins() {
		return coins;
	}

	public void setCoins(int coins) {
		this.coins = coins;
	}

}
