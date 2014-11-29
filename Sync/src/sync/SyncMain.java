package sync;

import java.util.ArrayList;
import java.util.List;

public class SyncMain {
	public static void main(String[] args) throws Exception {
		DataHolder dh = new DataHolder();

		int M = 3;
		List<WorkerThread> threads = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			WorkerThread wt = new WorkerThread(dh);
			threads.add(wt);
			wt.start();
		}

		for (WorkerThread wt : threads) {
			wt.join();
		}

		System.out.println(dh.getData());

	}
}
