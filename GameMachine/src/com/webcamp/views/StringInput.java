package com.webcamp.views;

import java.util.Scanner;

public class StringInput implements View {

	private String label;
	private String input;
	private int minLength;

	public String getInput() {
		return input;
	}

	public StringInput(String label, int minLength) {
		this.label = label;
		this.minLength = minLength;
	}

	@Override
	public void show(Scanner scanner) {
		while (true) {
			System.out.print(label);
			input = scanner.nextLine();
			if (minLength != 0) {
				if (input.trim().length() < minLength) {
					System.out.println("String length should be at least "
							+ minLength);
				} else {
					break;
				}
			} else {
				break;
			}
		}
	}
}
