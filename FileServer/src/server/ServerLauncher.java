package server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

import shared.Constants;

public class ServerLauncher {

	public static void main(String[] args) {
		try (ServerSocket serverSocket = new ServerSocket();) {
			serverSocket.bind(new InetSocketAddress(Constants.SERVER_ADRESS,
					Constants.SERVER_PORT), Constants.BACKLOG);
			System.out.println("Server started on: "
					+ serverSocket.getLocalSocketAddress());
			boolean keepRunning = true;
			while (keepRunning) {
				Socket socket = serverSocket.accept();
				System.out.println("Connection accepted from "
						+ socket.getRemoteSocketAddress() + " on "
						+ socket.getLocalSocketAddress());
				new WorkerThread(socket).start();
			}
		} catch (IOException ioe) {

		}
	}
}
