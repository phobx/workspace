package sync;

public class WorkerThread extends Thread {

	public static final int N = 100000;

	private DataHolder dh;

	public WorkerThread(DataHolder dh) {
		this.dh = dh;
	}

	@Override
	public void run() {
		for (int i = 0; i < N; i++) {
			dh.increaseData();
		}
	}

}
