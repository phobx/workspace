package com.webcamp.views;

import java.util.Scanner;

public class WelcomeView implements View {

	private String userName;

	public String getUserName() {
		return userName;
	}

	@Override
	public void show(Scanner scanner) {
		System.out.println("Welcome to the Game Machine, Looser!");
		InputHelper ih = new InputHelper("Input your name: ");
		ih.show(scanner);
		userName = ih.getInput();
		System.out.println("Ok, " + userName + ", go on...");
	}
}
