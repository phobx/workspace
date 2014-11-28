package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import shared.LsRequest;
import shared.LsResponse;
import shared.Request;
import shared.Response;

public class WorkerThread extends Thread {

	private Socket socket;

	public WorkerThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			Request req = (Request) ois.readObject();
			Response resp = null;
			if (req instanceof LsRequest) {
				LsResponse r = new LsResponse();
				r.addFile("One.txt");
				r.addFile("Two.txt");
				r.addFile("Three.txt");
				resp = r;
			}
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			oos.writeObject(resp);
			oos.flush();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		try {
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
