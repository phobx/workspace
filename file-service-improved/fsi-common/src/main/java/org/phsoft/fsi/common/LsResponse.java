package org.phsoft.fsi.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LsResponse extends Response {

	private List<String> files = new ArrayList<>();
	private String finalMessage = "No files on server found.";

	public List<String> getFiles() {
		return Collections.unmodifiableList(files);
	}

	public void addFile(String s) {
		this.files.add(s);
	}

	public String getFinalMessage() {
		if (files != null && files.size() > 0) {
			finalMessage = "Number of files : " + files.size();
		}

		return finalMessage;
	}
}
