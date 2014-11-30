package client;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import shared.LsRequest;
import shared.LsResponse;

public class LsCommand extends AbstractCommand {

	@Override
	public void runCommand(String[] cmd) throws Exception {
		Socket socket = createSocket();
		ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
		oos.writeObject(new LsRequest());
		ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
		LsResponse response = (LsResponse) ois.readObject();
		if (response.getFiles().size() > 0) {
			System.out.println("File list on remote system: ");
			for (String fileName : response.getFiles()) {
				System.out.println("	" + fileName);
			}
		}
		System.out.println(response.getFinalMessage());
	}

	@Override
	public String getHelp() {
		return "Lists files on remote system";
	}

}
