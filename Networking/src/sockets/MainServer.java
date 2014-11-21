package sockets;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class MainServer {
	public static void main(String[] args) throws Exception {
		System.out.println("Server Started");
		ServerSocket ss = new ServerSocket();
		ss.bind(new InetSocketAddress(Commons.SERVER_PORT));

		while (true) {
			Socket s = ss.accept();
			ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
			String name = (String) ois.readObject();

			if (name.equals("quit")) {
				ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
				oos.writeObject("Server quits");
				oos.flush();
				break;
			} else {
				ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
				oos.writeObject("Hello, " + name);
				oos.flush();
			}
			System.out.println("Connection Processed");
		}

	}
}
