package com.webcamp.dao;

import com.webcamp.dto.Player;

public class PlayerInMemoryDao implements PlayerDao {

	private Player player;

	@Override
	public Player getPlayerByName(String name) {
		System.out.println("Log: loading player " + name);
		if (player != null && player.getName().equals(name)) {
			return player;
		}
		return null;
	}

	@Override
	public void savePlayer(Player player) {
		System.out.println("Log: saving player " + player.getName());
		this.player = player;
	}

}
