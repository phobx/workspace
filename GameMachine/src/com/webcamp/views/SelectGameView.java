package com.webcamp.views;

import java.util.Scanner;

import com.webcamp.dto.Game;
import com.webcamp.dto.Player;

public class SelectGameView implements View {

	private Game[] games;
	private Player player;
	private Game selectedGame;

	public Game getSelectedGame() {
		return selectedGame;
	}

	public SelectGameView(Game[] games, Player player) {
		this.games = games;
		this.player = player;
	}

	@Override
	public void show(Scanner scanner) {
		for (int i = 0; i < games.length; i++) {
			System.out.println((1 + i) + " - " + games[i].getName());
		}
		System.out.println("0 - Exit");
		IntegerInput ih = new IntegerInput("Select your game: ", 0,
				games.length);
		ih.show(scanner);
		if (ih.getInput() != 0) {
			selectedGame = games[ih.getInput() - 1];
		}
	}

}
