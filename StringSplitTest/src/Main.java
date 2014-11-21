import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {
	public static void main(String[] args) throws Exception {

		// ----------------CREATE DIRECTORY & GET FILES
		File dir = new File("dir");
		if (!dir.exists()) {
			dir.mkdirs();
		}
		File[] files = dir.listFiles();
		for (File f : files) {
			System.out.println(f.getAbsolutePath());
		}

		// ------------------CREATE NEW FILE--------------------
		File f = files[0];
		String newname = f.getName().replace("srt", "txt");
		File nf = new File(newname);

		if (!nf.exists()) {
			nf.createNewFile();
		}

		// =======================READ & WRITE===============
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f), "CP1251"));
		PrintWriter pw = new PrintWriter(nf);
		StringBuilder text = new StringBuilder("");

		while (true) {
			String l = br.readLine();
			if (l == null) {
				break;
			}

			pw.append(l + System.lineSeparator());
			text.append(l + System.lineSeparator());

		}

		br.close();
		pw.close();

		String[] rows = text.toString().trim().split("(\r\n){2,}");

		for (int i = 0; i < rows.length; i++) {
			System.out.println("# " + (i + 1) + " : " + rows[i]);
		}

		System.out.println("LENGTH : " + rows.length);

		// String r = rows[5];
		for (String row : rows) {
			// String[] mr = row.split(System.lineSeparator());
			// System.out.println(mr.length);

		}
	}
}
