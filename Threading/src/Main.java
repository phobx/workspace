import java.util.Random;

public class Main {

	public static final int SIZE = 200000;

	public static void main(String[] args) throws InterruptedException {

		Random r = new Random(1953);
		int[] array = new int[SIZE];
		for (int i = 0; i < SIZE; i++) {
			array[i] = r.nextInt();
		}

		long t1 = System.nanoTime();
		System.out.println(Main.min(array, 0, SIZE));
		long t2 = System.nanoTime();

		long t3 = System.nanoTime();
		CalcThread T1 = new CalcThread(array, 0, SIZE / 2);
		CalcThread T2 = new CalcThread(array, SIZE / 2, SIZE);

		T1.start();
		T2.start();

		T1.join();
		T2.join();
		long t4 = System.nanoTime();

		System.out.println(T1.getMin() < T2.getMin() ? T1.getMin() : T2.getMin());

		System.out.println(t2 - t1);
		System.out.println(t4 - t3);

	}

	public static int min(int[] array, int start, int end) {
		int min = array[start];
		for (int i = start + 1; i < end; i++) {
			if (array[i] < min) {
				min = array[i];
			}
		}
		return min;
	}
}
