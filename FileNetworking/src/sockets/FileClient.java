package sockets;

import java.net.Socket;
import java.util.Scanner;

public class FileClient {
	public static void main(String[] args) throws Exception {
		Socket s = new Socket("127.0.0.1", Connections.SERVER_PORT);
		boolean answer = true;

		do {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter command :");
			String command = scanner.nextLine();
			new Connections().writeToSocket(s, command);

			System.out.println(new Connections().readFromSocket(s));

			System.out.println("Repeat? y/n");
			answer = scanner.nextLine().trim().toLowerCase().equals("y");

			if (!answer) {
				new Connections().writeToSocket(s, "exit");
			}
		} while (answer);
	}
}
