import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class WordCounter {

	public static void main(String[] args) {

		File f = new File("Amber.txt");
		String newline = System.lineSeparator();
		String sub = "Эрик";

		// Method #1
		StringBuilder text = new StringBuilder("");

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
			while (true) {
				String s = br.readLine();
				if (s == null) {
					break;
				}
				text.append(s);
				text.append(newline);

			}

			br.close();

		} catch (FileNotFoundException e) {
			System.out.println("File \"" + f.toString() + "\" not found in project directory!");
			return;
		} catch (IOException e) {
			e.printStackTrace();
		}

		long q = (text.length() - text.toString().replaceAll(sub, "").length()) / sub.length();
		System.out.println("Amount of words \"" + sub + "\" found in file \"" + f.toString() + "\" by 1st method: " + q);

		// Method #2
		int count = 0;
		try {
			BufferedReader br2 = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
			while (true) {
				String s = br2.readLine();
				if (s == null) {
					break;
				}
				while (s.indexOf(sub) >= 0) {
					count++;
					s = s.substring(s.indexOf(sub) + sub.length());
				}

			}

			br2.close();

		} catch (FileNotFoundException e) {
			System.out.println("File \"" + f.toString() + "\" not found in project directory!");
			return;
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Amount of words \"" + sub + "\" found in file \"" + f.toString() + "\" by 2nd method: " + count);

	}
}
