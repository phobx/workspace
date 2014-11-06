package com.webcamp.controllers;

import java.util.Scanner;

import com.webcamp.dto.Game;
import com.webcamp.dto.GuessNumberGame;
import com.webcamp.dto.Player;
import com.webcamp.dto.TestGame;
import com.webcamp.views.GoodbyeView;
import com.webcamp.views.SelectGameView;
import com.webcamp.views.WelcomeView;

public class GameMachine {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		WelcomeView welcomeView = new WelcomeView();
		welcomeView.show(sc);

		// Player DTO
		Player player = new Player();
		player.setName(welcomeView.getUserName());
		player.setCoins(100);

		// Games DTO
		Game[] games = new Game[2];
		games[0] = new GuessNumberGame();
		games[1] = new TestGame();

		SelectGameView selectGameView = new SelectGameView(games, player);
		selectGameView.show(sc);

		new GoodbyeView().show(sc);

		sc.close();
	}
}
