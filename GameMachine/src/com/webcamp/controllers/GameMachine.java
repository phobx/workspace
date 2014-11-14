package com.webcamp.controllers;

import java.util.Scanner;

import com.webcamp.dao.PlayerDao;
import com.webcamp.dao.PlayerFileDao;
import com.webcamp.dto.Game;
import com.webcamp.dto.Player;
import com.webcamp.views.GoodbyeView;
import com.webcamp.views.MessageView;
import com.webcamp.views.SelectGameView;
import com.webcamp.views.WelcomeView;

public class GameMachine {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// PlayerDao playerDao = new PlayerInMemoryDao();
		PlayerDao playerDao = new PlayerFileDao();

		WelcomeView welcomeView = new WelcomeView();
		welcomeView.show(sc);
		String playerName = welcomeView.getUserName().trim();
		Player player = playerDao.getPlayerByName(playerName);
		if (player == null) {
			player = new Player();
			player.setName(welcomeView.getUserName().trim());
			player.setCoins(100);
			playerDao.savePlayer(player);
		} else {
			if (player.getCoins() <= 0) {
				new MessageView("Sorry, " + player.getName() + ", poor idiots are not allowed in this respectable casino!")
						.show(sc);
				return;
			}
		}

		// Games DTO
		Game[] games = new Game[1];
		games[0] = new Dice();

		while (true) {
			SelectGameView selectGameView = new SelectGameView(games, player);
			selectGameView.show(sc);

			if (selectGameView.getSelectedGame() == null) {
				new GoodbyeView().show(sc);
				break;
			} else {
				selectGameView.getSelectedGame().run(player, sc);
				playerDao.savePlayer(player);
			}
			if (player.getCoins() <= 0) {
				new MessageView("You lost everything and will be kicked out of here. And don't try to return, looser!")
						.show(sc);
				return;
			}
		}

		sc.close();
	}
}
