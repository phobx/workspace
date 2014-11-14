package com.webcamp.views;

import java.util.Scanner;

import com.webcamp.dto.Player;

public class HelloView implements View {

	private Player player;
	private String helloMessage;

	public HelloView(Player player, String helloMessage) {
		this.player = player;
		this.helloMessage = helloMessage;
	}

	@Override
	public void show(Scanner scanner) {
		System.out.println(helloMessage);
		System.out.println(player.getName() + ", your balance is "
				+ player.getCoins());
	}

}
