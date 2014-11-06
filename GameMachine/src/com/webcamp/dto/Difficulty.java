package com.webcamp.dto;

public enum Difficulty {
	EASYMODE(12, "You are retarded and you can win!"), NORMAL(7,
			"You still can win!"), HARDCORE(6, "One mistake means loose."), NIGHTMARE(
			5, "You will fail!");

	private final int guessNumberDifficulty;
	private final String message;

	Difficulty(int s, String m) {
		this.guessNumberDifficulty = s;
		this.message = m;
	}

	public int getGuessNumberDifficulty() {
		return guessNumberDifficulty;
	}

	public String getMessage() {
		return message;
	}

}
