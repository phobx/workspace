import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		final int SIZE = 10;
		List<Integer> randomIntegers = new ArrayList<>();
		Random r = new Random(2014);

		for (int i = 0; i < SIZE; i++) {
			randomIntegers.add(r.nextInt());
		}

		// Bubble sort
		for (int i = 0; i < randomIntegers.size() - 1; i++)
			for (int j = 0; j < randomIntegers.size() - i - 1; j++) {
				if (randomIntegers.get(j) > randomIntegers.get(j + 1)) {
					int temp = randomIntegers.get(j);
					randomIntegers.set(j, randomIntegers.get(j + 1));
					randomIntegers.set(j + 1, temp);
				}
			}

		for (int i = 0; i < randomIntegers.size() - 1; i++) {

		}

		// randomIntegers.sort();
	}
}