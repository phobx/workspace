package sockets;

import java.net.ServerSocket;
import java.net.Socket;

public class FileServer {

	public static void main(String[] args) throws Exception {
		System.out.println("File server is online.");
		ServerSocket ss = new ServerSocket(Connections.SERVER_PORT);

		while (true) {
			Socket s = ss.accept();
			String command = (String) new Connections().readFromSocket(s);
			System.out.println("Command : " + command);

			if (command.equals(Connections.EXIT_COMMAND)) {
				new Connections().writeToSocket(s, "Server going offline...");
				break;
			} else {
				new Connections().writeToSocket(s, "Performing " + command + "...");
			}

			System.out.println("Command processed.");
		}
	}

}
