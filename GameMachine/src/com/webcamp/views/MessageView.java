package com.webcamp.views;

import java.util.Scanner;

public class MessageView implements View {

	private String message;

	public MessageView(String message) {
		this.message = message;
	}

	@Override
	public void show(Scanner scanner) {
		System.out.println(message);
	}

}
