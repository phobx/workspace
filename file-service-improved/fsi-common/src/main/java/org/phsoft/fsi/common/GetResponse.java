package org.phsoft.fsi.common;
public class GetResponse extends Response {

	private int fileSize;
	private byte[] bytearray;

	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
	}

	public void setBytearray(byte[] bytearray) {
		this.bytearray = bytearray;
	}

	public int getFileSize() {
		return fileSize;
	}

	public byte[] getBytearray() {
		return bytearray;
	}

}
