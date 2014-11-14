package com.webcamp.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.webcamp.dto.Player;

public class PlayerFileDao implements PlayerDao {

	public static final String USERS_DIR = "users";

	@Override
	public Player getPlayerByName(String name) {
		File userFile = new File(getUsersDir(), name);
		if (userFile.exists()) {
			try {
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(userFile));
				Player player = (Player) ois.readObject();
				ois.close();
				return player;
			} catch (Exception e) {
				throw new RuntimeException("Cannot read user file", e);
			}
		}
		return null;
	}

	@Override
	public void savePlayer(Player player) {
		File userFile = new File(getUsersDir(), player.getName());
		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(userFile));
			oos.writeObject(player);
			oos.flush();
			oos.close();
		} catch (Exception e) {
			throw new RuntimeException("Cannot save user file", e);
		}
	}

	private File getUsersDir (){
		File dir = new File(USERS_DIR);
		dir.mkdirs();
		return dir;
	}
}
