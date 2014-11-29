package mapreduce;

public class WorkerThread extends Thread {

	private int[] data;
	private int startIdx;
	private int endIdx;
	private long sum;
	private double avg;

	public double getAvg() {
		return avg;
	}

	public long getSum() {
		return sum;
	}

	public WorkerThread(int[] data, int startIdx, int endIdx) {
		this.data = data;
		this.startIdx = startIdx;
		this.endIdx = endIdx;
	}

	@Override
	public void run() {
		long start = System.currentTimeMillis();
		sum = 0;
		for (int i = startIdx; i < endIdx; i++) {
			sum += data[i];
		}
		avg = (double) sum / (endIdx - startIdx);
		long end = System.currentTimeMillis();
		System.out.println(startIdx + " - " + endIdx + " took " + (end - start) / 1000.0 + " secs");
	}

}
