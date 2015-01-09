package Server;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import Common.CommonMain;

public class ServerMain {
	public static void main(String[] args) throws IOException {

		OutputStream os = null;
		try (ServerSocket servsock = new ServerSocket(CommonMain.PORT);) {

			while (true) {
				System.out.println("Waiting...");
				try (Socket sock = servsock.accept();) {
					System.out.println("Accepted connection : " + sock);
					// send file
					File myFile = new File("s1.pdf");
					byte[] mybytearray = new byte[(int) myFile.length()];
					FileInputStream fis = new FileInputStream(myFile);
					BufferedInputStream bis = new BufferedInputStream(fis);
					bis.read(mybytearray, 0, mybytearray.length);
					os = sock.getOutputStream();
					System.out.println("Sending file (" + mybytearray.length
							+ " bytes)");
					os.write(mybytearray, 0, mybytearray.length);
					os.flush();
					System.out.println("Done.");
				} finally {

					if (os != null)
						os.close();
				}
			}
		}
	}
}