package sockets;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Connections {
	public static final int SERVER_PORT = 1729;

	public static final String EXIT_COMMAND = "exit";
	public static final String LIST_COMMAND = "ls";
	public static final String REMOVE_COMMAND = "rm";
	public static final String DOWNLOAD_COMMAND = "get";
	public static final String HELP_COMMAND = "help";

	public void writeToSocket(Socket s, String c) throws IOException {
		ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
		oos.writeObject(c);
		oos.flush();
	}

	public String readFromSocket(Socket s) throws IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
		String c = (String) ois.readObject();
		return c.trim();
	}
}
