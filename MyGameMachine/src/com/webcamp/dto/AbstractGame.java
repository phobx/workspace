package com.webcamp.dto;

public abstract class AbstractGame implements Game {

	protected String name;

	public void start() {
		System.out.println("«" + getName() + "» LOADED.");
	}

	public AbstractGame(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

}
