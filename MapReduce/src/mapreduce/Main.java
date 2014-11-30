package mapreduce;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
	public static void main(String[] args) throws Exception {
		System.out.println("Started");
		int N = 500000000;
		int[] data = new int[N];
		Random rnd = new Random(0);
		for (int i = 0; i < data.length; i++) {
			data[i] = rnd.nextInt();
		}
		System.out.println("Data created");
		long start = System.currentTimeMillis();
		List<WorkerThread> threads = new ArrayList<>();

		int M = 4;
		for (int i = 0; i < M; i++) {
			WorkerThread wth = new WorkerThread(data, data.length / M * i, data.length / M * (i + 1));
			threads.add(wth);
			wth.start();
		}

		for (WorkerThread wt : threads) {
			wt.join();
		}

		double overallAvg = 0;
		for (WorkerThread wt : threads) {
			overallAvg += wt.getAvg();
		}
		overallAvg /= M;
		System.out.println(overallAvg);
		long end = System.currentTimeMillis();
		System.out.println("Done in: " + ((end - start) / 1000.0) + " secs");
	}
}
