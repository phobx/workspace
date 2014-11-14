package com.webcamp.dto;

import java.util.Random;
import java.util.Scanner;

import com.webcamp.views.InputHelper;

public class GuessNumberGame extends AbstractGame {

	private int number;
	private int difficulty = 8;

	public GuessNumberGame() {
		super("Guess Number 1.0");

	}

	@Override
	public void start() {

		super.start();

		int rand = 0;
		number = new Random().nextInt(100) + 1;

		InputHelper selectDifficulty = new InputHelper("Select difficulty : ");

		int j = 1;
		for (Difficulty d : Difficulty.values()) {
			System.out.println("#" + j + " : " + d + ". You have "
					+ d.getGuessNumberDifficulty() + " tries. "
					+ d.getMessage());
			j++;
		}
		selectDifficulty.show(new Scanner(System.in));

		try {
			difficulty = Difficulty.values()[Integer.parseInt(selectDifficulty
					.getInput()) - 1].getGuessNumberDifficulty();
		} catch (Exception e) {
			System.out.println("Error happened :( Difficulty set to normal.");
			difficulty = Difficulty.NORMAL.getGuessNumberDifficulty();
		} finally {
			System.out.println("You have " + difficulty
					+ " chances. Let's check your luck!");
		}

		for (int i = 0; i < difficulty; i++) {

			InputHelper ih = new InputHelper("Try #" + (i + 1)
					+ ". Enter number from 1 to 100 : ");
			ih.show(new Scanner(System.in));

			try {
				rand = Integer.parseInt(ih.getInput());

				if (rand == number) {

					break;
				} else if (rand <= number) {
					System.out.println("Too small.");
				} else {
					System.out.println("Too big.");
				}
			} catch (Exception e) {
				System.out.println("You must enter a number! Try again.");
				i--;
				// e.printStackTrace();
			}

		}

		if (rand == number) {
			System.out.println("You are lucky today! Number is " + number);
		} else {
			System.out.println("Loser! Try another time. Number is " + number);
		}

	}

	// public static void main(String[] args) {
	// new GuessNumberGame().start();
	// }
}