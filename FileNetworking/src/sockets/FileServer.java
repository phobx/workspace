package sockets;

import java.io.File;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FileServer {

	public static void main(String[] args) {
		try {
			System.out.println("File server is online.");
			ServerSocket ss = new ServerSocket(Connections.SERVER_PORT);
			Socket s = ss.accept();

			ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
			ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());

			File dir = new File(Connections.FILE_DIR);
			if (!dir.isDirectory()) {
				dir.mkdirs();
			}

			List<File> files = new LinkedList<>(Arrays.asList(dir.listFiles()));

			while (true) {
				String command = (String) ois.readObject();
				System.out.println("Command :>>>" + command + "<<<");

				if (command.equals(Connections.EXIT_COMMAND)) {
					oos.writeObject("Server going offline...");
					break;
				} else if (command.equals(Connections.LIST_COMMAND)) {
					oos.writeObject(FileServer.toFileList(files));
				} else if (command.equals(Connections.HELP_COMMAND)) {
					oos.writeObject(Connections.HELP_NOTES);
				} else if (command.startsWith(Connections.REMOVE_COMMAND + " ")) {

					String filename = command.substring(3);
					boolean fileNotFound = true;
					for (File f : files) {
						if (f.getName().equals(filename)) {
							fileNotFound = false;
							oos.writeObject("Removing " + filename);
							files.remove(f);
						}
					}

					if (fileNotFound) {
						oos.writeObject("File not found.");
					}

				} else if (command.startsWith(Connections.DOWNLOAD_COMMAND + " ")) {

					String filename = command.substring(4);
					boolean fileNotFound = true;
					for (File f : files) {
						if (f.getName().equals(filename)) {
							fileNotFound = false;
							oos.writeObject("Downloading " + filename);
						}
					}

					if (fileNotFound) {
						oos.writeObject("File not found.");
					}

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

	public static String toFileList(List<File> files) {
		String filesList = "";
		for (int i = 0; i < files.size(); i++) {
			filesList = filesList + (i + 1) + " - " + files.get(i).getName() + "\r\n";
		}
		filesList = filesList + "Total: " + files.size() + " files.";
		return filesList;
	}
}
