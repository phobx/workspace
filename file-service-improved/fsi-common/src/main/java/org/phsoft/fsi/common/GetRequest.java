package org.phsoft.fsi.common;
public class GetRequest extends Request {

	private String filename;

	public String getFilename() {
		return filename;
	}

	public GetRequest(String filename) {
		this.filename = filename;
	}
}