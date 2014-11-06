package com.webcamp.views;

import java.util.Scanner;

public class InputHelper implements View {

	private String label;
	private String input;

	public String getInput() {
		return input;
	}

	public InputHelper(String label) {
		this.label = label;
	}

	@Override
	public void show(Scanner scanner) {
		System.out.print(label);
		input = scanner.nextLine();
	}

}
