import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

	public static final int SIZE = 1000;

	public static void main(String[] args) {
		List<Integer> ri = new ArrayList<>();
		List<Integer> ri2 = new ArrayList<>();
		Random r = new Random(2014);
		Random r2 = new Random(2014);

		Main.fillWithRandomIntegers(ri, r);
		Main.fillWithRandomIntegers(ri2, r2);

		System.out.println("Before sorting:");
		Main.show(ri);
		Main.show(ri2);

		// Bubble sort
		long bubbleStart = System.nanoTime();
		for (int i = 0; i < ri.size() - 1; i++) {
			for (int j = 0; j < ri.size() - i - 1; j++) {
				if (ri.get(j) > ri.get(j + 1)) {
					int temp = ri.get(j);
					ri.set(j, ri.get(j + 1));
					ri.set(j + 1, temp);
				}
			}
		}
		long bubbleEnd = System.nanoTime();

		// Insertion sort
		long insertionStart = System.nanoTime();
		for (int i = 1; i < ri2.size(); i++) {
			for (int j = i; (j > 0) && (ri2.get(j - 1) > ri2.get(j)); j--) {
				int temp = ri2.get(j - 1);
				ri2.set(j - 1, ri2.get(j));
				ri2.set(j, temp);

			}
		}
		long insertionEnd = System.nanoTime();

		System.out.println("After sorting:");
		Main.show(ri);
		Main.show(ri2);

		System.out.println("Time for bubble sort : " + (bubbleEnd - bubbleStart) + " ns.");
		System.out.println("Time for insertion sort : " + (insertionEnd - insertionStart) + " ns.");

	}

	public static void show(List<Integer> l) {
		for (int i = 0; i < l.size(); i++) {
			System.out.println("#" + (i + 1) + " : " + l.get(i));
		}

		System.out.println("********************************");

	}

	public static void fillWithRandomIntegers(List<Integer> l, Random r) {
		for (int i = 0; i < SIZE; i++) {
			l.add(r.nextInt());
		}
	}
}
