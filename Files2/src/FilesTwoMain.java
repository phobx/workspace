import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class FilesTwoMain {

	public static void main(String[] args) {
		File dir = new File("dir");
		dir.mkdirs();
		final String newline = System.lineSeparator();

		File f = new File(dir, "DEADBEEF.txt");

		try {
			if (!f.exists())
				f.createNewFile();

		} catch (IOException e) {
			e.printStackTrace();
		}

		int[] deadBeef = new int[] { 0xDE, 0xAD, 0xBE, 0xEF };
		try {

			FilesTwoMain.writeIntegers(f, deadBeef);

		} catch (IOException e) {
			e.printStackTrace();
		}

		File table = new File(dir, "Multiplication Table.txt");
		try {
			PrintWriter pw = new PrintWriter(table);
			for (int i = 2; i < 10; i++) {
				pw.append(newline + "Multiplication by " + i + newline);
				for (int j = 2; j < 10; j++) {
					pw.append(j + " * " + i + " = " + (i * j) + newline);
				}
			}

			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					new FileInputStream(table)));
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

	// function for writing array of integers
	public static void writeIntegers(File f, int[] a) throws IOException {
		FileOutputStream op = new FileOutputStream(f);
		for (int i = 0; i < a.length; i++) {
			op.write(a[i]);
		}
		op.close();
	}

}
