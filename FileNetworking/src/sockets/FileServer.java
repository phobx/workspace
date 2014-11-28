package sockets;

import java.io.File;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileServer {

	public static void main(String[] args) {
		try {
			System.out.println("File server is online.");
			ServerSocket ss = new ServerSocket(Commons.SERVER_PORT);
			Socket s = ss.accept();

			ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
			ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());

			String filesList = "";
			File dir = new File(Commons.FILE_DIR);
			if (!dir.isDirectory()) {
				dir.mkdirs();
			}
			List<File> files = new ArrayList<>(Arrays.asList(dir.listFiles()));

			for (int i = 0; i < files.size(); i++) {
				filesList = filesList + (i + 1) + " - " + files.get(i).getName() + "\r\n";
			}
			filesList = filesList + "Total: " + files.size() + " files.";

			while (true) {
				String command = (String) ois.readObject();
				System.out.println("Command :>>>" + command + "<<<");

				if (command.equals(Commons.EXIT_COMMAND)) {
					oos.writeObject("Server going offline...");
					break;
				} else if (command.equals(Commons.LIST_COMMAND)) {
					oos.writeObject(filesList);
				} else if (command.equals(Commons.HELP_COMMAND)) {
					oos.writeObject(Commons.HELP_NOTES);
				} else if (command.startsWith(Commons.REMOVE_COMMAND)) {
					oos.writeObject("Removing...");
				} else if (command.startsWith(Commons.DOWNLOAD_COMMAND)) {
					oos.writeObject("Downloading...");
				} else {
					oos.writeObject("Unknown command. Type 'help' for more commands.");
				}

				System.out.println("Command processed.");
			}

			System.out.println("Server going offline...");
			ss.close();
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}
}
