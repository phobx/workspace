package shared;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LsResponse extends Response {

	private List<String> files = new ArrayList<>();

	public List<String> getFiles() {
		return Collections.unmodifiableList(files);
	}

	public void addFile(String s) {
		this.files.add(s);
	}
}
