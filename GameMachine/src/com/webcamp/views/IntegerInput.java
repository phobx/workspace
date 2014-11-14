package com.webcamp.views;

import java.util.Scanner;

public class IntegerInput implements View {

	private String label;
	private int input;
	private int min;
	private int max;

	public int getInput() {
		return input;
	}

	public IntegerInput(String label, int min, int max) {
		this.label = label;
		this.min = min;
		this.max = max;
	}

	@Override
	public void show(Scanner scanner) {
		while (true) {
			System.out.print(label);
			String s = scanner.nextLine();
			try {
				input = Integer.parseInt(s);
				if (input < min || input > max) {
					throw new IllegalArgumentException();
				}
				break;
			} catch (NumberFormatException e) {
				System.out.println("Input integer number!");
			} catch (IllegalArgumentException e) {
				System.out.println("Value should be in range from " + min
						+ " to " + max);
			}
		}
	}
}
