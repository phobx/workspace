package Server;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {
	public static void main(String[] args) throws IOException {

		File myFile = new File("s1.pdf");
		byte[] mybytearray = new byte[(int) myFile.length()];
		FileInputStream fis = new FileInputStream(myFile);

		try (ServerSocket servsock = new ServerSocket(12345);
				Socket sock = servsock.accept();
				BufferedInputStream bis = new BufferedInputStream(fis);
				OutputStream os = sock.getOutputStream();) {

			while (true) {
				System.out.println("Waiting...");

				System.out.println("Accepted connection : " + sock);

				bis.read(mybytearray, 0, mybytearray.length);
				System.out.println("Sending file (" + mybytearray.length
						+ " bytes)");
				os.write(mybytearray, 0, mybytearray.length);
				os.flush();
				System.out.println("Done.");

			}
		}
	}
}