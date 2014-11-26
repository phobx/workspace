public class CalcThread extends Thread {

	private int[] array;
	private int start;
	private int end;
	private int min;

	public int getMin() {
		return min;
	}

	public CalcThread(int[] array, int start, int end) {
		this.array = array;
		this.start = start;
		this.end = end;
	}

	@Override
	public void run() {
		this.min = Main.min(this.array, start, end);
	}

}
