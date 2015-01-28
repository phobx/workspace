import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import org.phsoft.fsi.common.GetRequest;
import org.phsoft.fsi.common.GetResponse;
import org.phsoft.fsi.common.LsRequest;
import org.phsoft.fsi.common.LsResponse;
import org.phsoft.fsi.common.Request;
import org.phsoft.fsi.common.Response;

public class WorkerThread extends Thread {

	private Socket socket;

	public WorkerThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			ObjectInputStream ois = new ObjectInputStream(
					socket.getInputStream());
			Request request = (Request) ois.readObject();
			Response response = null;
			if (request instanceof LsRequest) {
				LsResponse r = new LsResponse();
				String[] files = ServerData.dir.list();
				if (files != null) {
					for (String f : files) {
						r.addFile(f);
					}
				}
				response = r;
			} else if (request instanceof GetRequest) {
				GetResponse r = new GetResponse();
				String filename = ((GetRequest) request).getFilename();
				File file = new File(ServerData.dir, filename);
				if (file.exists()) {
					FileInputStream fis = new FileInputStream(file);
					BufferedInputStream bis = new BufferedInputStream(fis);
					byte[] bytearray = new byte[(int) file.length()];
					bis.read(bytearray, 0, (int) file.length());
					r.setBytearray(bytearray);
					r.setFileSize((int) file.length());
				} else {
					r.setFileSize(-1);
				}

				response = r;

			}
			ObjectOutputStream oos = new ObjectOutputStream(
					socket.getOutputStream());
			oos.writeObject(response);
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
