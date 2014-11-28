public class Main {

	public final static int N = 117;

	public static void main(String[] args) {
		int[][] q = new int[N][N];

		long st, en;

		// one
		st = System.nanoTime();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				q[i][j] = i + j;
			}
		}
		en = System.nanoTime();
		System.out.println("\nOne time " + (en - st) / 1000000.d + " msc");

		// two
		st = System.nanoTime();
		for (int i = 0; i < N; i++) {
			q[i][i] = i + i;
			for (int j = 0; j < i; j++) {
				q[j][i] = q[i][j] = i + j;
			}
		}
		en = System.nanoTime();
		System.out.println("\nTwo time " + (en - st) / 1000000.d + " msc");
	}
}
