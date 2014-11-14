package com.webcamp.views;

import java.util.Scanner;

import com.webcamp.dto.Game;
import com.webcamp.dto.Player;

public class SelectGameView implements View {

	private Game[] games;
	private Player player;

	public SelectGameView(Game[] games, Player player) {
		this.games = games;
		this.player = player;
	}

	@Override
	public void show(Scanner scanner) {
		boolean c = false;
		do {
			for (int i = 0; i < games.length; i++) {
				System.out.println((1 + i) + " - " + games[i].getName());
			}
			System.out.println("0 - Exit");

			try {
				InputHelper ih = new InputHelper("Select your game: ");
				ih.show(scanner);

				int choice = Integer.parseInt(ih.getInput());

				if (choice == 0) {
					break;
				}
				if (choice > 0 && choice < (games.length + 1)) {
					System.out.println("Game " + ih.getInput()
							+ " was selected");

					games[choice - 1].start();
					c = false;

				} else {
					throw new NumberFormatException();
				}
			} catch (NumberFormatException e) {
				System.out.println("What's wrong, " + player.getName()
						+ "? Mummy doesn't allow little boy to play?");
				// e.printStackTrace();
				c = true;
			}
		} while (c);

	}
}