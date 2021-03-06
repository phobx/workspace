import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) {

		File f = new File("Amber.txt");
		StringBuilder text = new StringBuilder("");

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
			while (true) {
				String s = br.readLine();
				if (s == null) {
					break;
				}
				text.append(s);
				text.append(System.lineSeparator());

			}

			br.close();

		} catch (FileNotFoundException e) {
			System.out.println("File \"" + f.toString() + "\" not found in project directory!");
			return;
		} catch (IOException e) {
			e.printStackTrace();
		}

		String[] words = text.toString().split("\\P{L}+");
		Map<String, Integer> m = new HashMap<>();

		for (String s : words) {

			String s2 = s.toLowerCase();
			if (!m.containsKey(s2)) {
				m.put(s2, 1);
			} else {
				int q;
				q = m.get(s2);
				q++;
				m.put(s2, q);
			}
		}

		for (String w : m.keySet()) {
			System.out.println(w + " : " + m.get(w));
		}

		System.out.println("Total number of symbols : " + text.length());
		System.out.println("Total number of words : " + words.length);
		System.out.println("Number of unique words : " + m.size());

	}

}
