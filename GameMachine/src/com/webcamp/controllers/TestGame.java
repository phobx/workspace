package com.webcamp.controllers;

import java.util.Scanner;

import com.webcamp.dto.AbstractGame;
import com.webcamp.dto.Player;

public class TestGame extends AbstractGame {

	public TestGame() {
		super("Test Game");
	}

	@Override
	public void run(Player player, Scanner scanner) {
		System.out.println("Nothing, just testing");
	}

}
