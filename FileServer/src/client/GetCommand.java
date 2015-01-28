package client;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import shared.GetRequest;
import shared.GetResponse;

public class GetCommand extends AbstractFileCommand {

	@Override
	public void runCommand(String[] cmd) throws Exception {

		if (cmd.length != 2) {
			System.out.println("Invalid argunents");
			return;
		}
		Socket socket = createSocket();
		String filename = cmd[1];
		ObjectOutputStream oos = new ObjectOutputStream(
				socket.getOutputStream());

		GetRequest request = new GetRequest(filename);
		oos.writeObject(request);

		ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
		GetResponse response = (GetResponse) ois.readObject();
		if (response.getFileSize() > -1) {
			File file = new File(ClientData.dir, filename);
			System.out.println("Downloading file «" + filename + "» ("
					+ response.getBytearray().length + " bytes)...");
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(response.getBytearray());
			fos.close();
		} else {
			System.out.println("File missing on server");
		}

	}

	@Override
	public String getHelp() {
		return "Downloads chosen file";
	}

}
