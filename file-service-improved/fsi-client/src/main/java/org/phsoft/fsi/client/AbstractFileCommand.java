package org.phsoft.fsi.client;


public abstract class AbstractFileCommand extends AbstractCommand {

	private String filename;

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

}
