import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
	public static void main(String[] ar) {
		int serverPort = 6666;
		String address = "127.0.0.1";

		try {
			InetAddress ipAddress = InetAddress.getByName(address);
			System.out.println("Any of you heard of a socket with IP address " + address + " and port " + serverPort + "?");
			Socket socket = new Socket(ipAddress, serverPort);
			System.out.println("Yes! I just got hold of the program.");

			InputStream sin = socket.getInputStream();
			OutputStream sout = socket.getOutputStream();

			DataInputStream in = new DataInputStream(sin);
			DataOutputStream out = new DataOutputStream(sout);

			BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
			String line = null;
			System.out.println("Type in something and press enter. Will send it to the server and tell ya what it thinks.");
			System.out.println();

			while (true) {
				line = keyboard.readLine();
				System.out.println("Sending this line to the server...");
				out.writeUTF(line);
				out.flush();
				line = in.readUTF();

				System.out.println("The server was very polite. It sent me this : " + line);
				System.out.println("Looks like the server is pleased with us. Go ahead and enter more lines.");
				System.out.println();
			}
		} catch (Exception x) {
			x.printStackTrace();
		}
	}
}