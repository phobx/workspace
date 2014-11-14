package com.webcamp.dao;

import com.webcamp.dto.Player;

public interface PlayerDao {

	public Player getPlayerByName(String name);

	public void savePlayer(Player player);
}
