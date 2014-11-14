package com.webcamp.controllers;

import java.util.Random;
import java.util.Scanner;

import com.webcamp.dto.AbstractGame;
import com.webcamp.dto.Player;
import com.webcamp.views.HelloView;
import com.webcamp.views.IntegerInput;
import com.webcamp.views.MessageView;

public class Dice extends AbstractGame {

	public Dice() {
		super("Dice");
	}

	@Override
	public void run(Player player, Scanner scanner) {
		new HelloView(player, "Welcome to the game of Dice!").show(scanner);

		Random rnd = new Random();

		while (true) {
			int die1 = rnd.nextInt(6) + 1;
			int die2 = rnd.nextInt(6) + 1;

			int sum = die1 + die2;

			IntegerInput betInput = new IntegerInput("Make your bet (0 - exit, max " + player.getCoins() + "): ", 0,
					player.getCoins());
			betInput.show(scanner);
			int bet = betInput.getInput();

			if (bet == 0) {
				new MessageView("Get back soon!").show(scanner);
				break;
			}

			IntegerInput resultInput = new IntegerInput("What do you think result will be (2-12): ", 2, 12);
			resultInput.show(scanner);
			int result = resultInput.getInput();

			new MessageView("Throwing... And it's " + die1 + " and " + die2 + " which gives " + sum).show(scanner);

			if (result == sum) {
				new MessageView("You earned " + bet).show(scanner);
				player.setCoins(player.getCoins() + bet);
			} else {
				new MessageView("You lost " + bet + " as always...").show(scanner);
				player.setCoins(player.getCoins() - bet);
			}

			if (player.getCoins() == 0) {
				new MessageView("Your are broke now. Get lost looser, this is respectable casino!").show(scanner);
				break;
			}
		}
	}

}
