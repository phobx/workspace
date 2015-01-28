package org.phsoft.fsi.client;

import java.net.InetSocketAddress;
import java.net.Socket;

import org.phsoft.fsi.common.Constants;

public abstract class AbstractCommand {

	public abstract void runCommand(String[] cmd) throws Exception;

	public abstract String getHelp();

	protected Socket createSocket() throws Exception {
		Socket socket = new Socket();
		socket.connect(new InetSocketAddress(Constants.SERVER_ADRESS,
				Constants.SERVER_PORT));
		System.out.println("Client connection established on "
				+ socket.getLocalSocketAddress() + " to "
				+ socket.getRemoteSocketAddress());
		return socket;
	}

}
