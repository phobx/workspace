package sockets;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class MainClient {
	public static void main(String[] args) throws Exception {
		Socket s = new Socket("127.0.0.1", Commons.SERVER_PORT);

		ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
		oos.writeObject("John");
		// oos.writeObject("quit");
		oos.flush();

		ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
		String response = (String) ois.readObject();
		System.out.println(response);
		System.out.println("Done");
	}
}
