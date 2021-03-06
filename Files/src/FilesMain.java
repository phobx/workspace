import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class FilesMain {

	public static void main(String[] args) throws UnsupportedEncodingException {
		File dir = new File("dir/A");
		dir.mkdirs();

		File file = new File(dir, "test.data.");

		System.out.println("exists: " + file.exists());

		try {
			boolean createResult = file.createNewFile();
			System.out.println("created: " + createResult);
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("length: " + file.length());
		// System.out.println("can execute: " + file.canExecute());
		// System.out.println("can write: " + file.canWrite());
		// System.out.println("free space: " + file.getFreeSpace());

		FileOutputStream fos;
		try {
			fos = new FileOutputStream(file);
			fos.write(0xDE);
			fos.write(0xAD);
			fos.write(0xBE);
			fos.write(0xEF);
			// fos.write(buffer);
			fos.flush();
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			FileInputStream fis = new FileInputStream(file);
			int b;
			while (true) {
				b = fis.read();
				if (b == -1) {
					break;
				} else {
					// System.out.println(b);
				}

				fis.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			PrintWriter pw = new PrintWriter(new File("pw.txt"));
			pw.append("Hello!");
			pw.append('\n');
			pw.append("world!");
			pw.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("pw.txt"))));
			while (true) {
				String s = br.readLine();
				if (s == null) {
					break;
				}
				System.out.println(s);
			}

			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}