package sockets;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class FileClient {
	public static void main(String[] args) {

		try {
			Socket s = new Socket("127.0.0.1", Connections.SERVER_PORT);

			ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
			ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
			System.out.println("Client is on.");

			while (true) {
				Scanner sc = new Scanner(System.in);
				System.out.println("Enter command :");
				String command = sc.nextLine().trim();
				oos.writeObject(command);
				String response = (String) ois.readObject();
				System.out.println(response);
			}

		} catch (Exception e) {
			e.printStackTrace(System.out);
		}

	}
}
