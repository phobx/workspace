package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Subtitles {

	private File srt;
	private File txt;
	private Subtitle[] subtitles;

	public Subtitles(File file, boolean isSubrip) throws IOException {

		if (isSubrip) {
			StringBuilder text = new StringBuilder("");
			this.srt = file;
			if (file.exists()) {

				BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "CP1251"));
				while (true) {
					String s = br.readLine();
					if (s == null) {
						break;
					}
					text.append(s);
					text.append(System.lineSeparator());

				}

				br.close();

				// TODO do subtitles from srt
				String[] rows = text.toString().trim().split("(\r\n){2,}");
			}
		} else {
			this.txt = file;
			StringBuilder text = new StringBuilder("");
			if (file.exists()) {

				BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "CP1251"));
				while (true) {
					String s = br.readLine();
					if (s == null) {
						break;
					}
					text.append(s);
					text.append(System.lineSeparator());

				}

				br.close();

				// TODO do subtitles from txt
				String[] rows = text.toString().trim().split("(\r\n){1,}");
			}
		}

	}

	public File toText(File destDir) throws IOException {
		String s = srt.getName();

		if (s.endsWith("srt")) {
			s = s.substring(0, s.length() - 4) + ".txt";
		} else {
			s = s + ".txt";
		}

		this.txt = new File(destDir, s);
		if (!this.txt.exists()) {
			this.txt.createNewFile();
		}

		// String[] rows = text.toString().split(System.lineSeparator());
		return txt;

	}

	public File toSubrip() {
		return srt;

	}

}
