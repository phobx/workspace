package shared;

public class GetResponse extends Response {

	private boolean fileFound;

	public void setFileFound(boolean fileFound) {
		this.fileFound = fileFound;
	}

	public boolean getFileFound() {
		return fileFound;
	}
}
