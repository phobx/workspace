package controller;

public class Subtitle {
	private int index;
	private String timecode;
	private String text;

	public int getIndex() {
		return index;
	}

	public String getTimecode() {
		return timecode;
	}

	public String getText() {
		return text;
	}

	public Subtitle(int index, String timecode, String text) {
		this.index = index;
		this.timecode = timecode;
		this.text = text;
	}

}
