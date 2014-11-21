package controller;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {
	public static void main(String[] args) throws Exception {

		String nl = System.lineSeparator();
		File inputDirectory = new File("input");
		inputDirectory.mkdirs();

		File outputDirectory = new File("output");
		outputDirectory.mkdirs();

		File[] srt = inputDirectory.listFiles();

		for (File f : srt) {
			String s = f.getAbsolutePath();
			System.out.println(s);
		}

		for (File f : srt) {

			String s = f.getName();

			if (s.endsWith("srt")) {
				s = s.substring(0, s.length() - 4) + ".txt";
			}

			File nf = new File(outputDirectory, s);
			if (!nf.exists()) {
				nf.createNewFile();
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f), "CP1251"));
			PrintWriter pw = new PrintWriter(nf);

			while (true) {
				String l = br.readLine();
				if (l == null) {
					break;
				}

				pw.append(l + nl);

			}

			br.close();
			pw.close();

		}
	}
}
