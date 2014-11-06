public class Euclid {
	public static void main(String[] args) {
		System.out.println(Euclid.GCD(288, 56));
		System.out.println(Euclid.GCD2(56, 288));
		System.out.println(Euclid.LCM(36, 312));
	}

	// method with recursion
	public static int GCD(int a, int b) {
		if (b == 0)
			return a;
		return GCD(b, a % b);
	}

	public static int GCD2(int a, int b) {
		int r = 1;
		while (b != 0) {
			r = a % b;
			a = b;
			b = r;
		}
		return a;
	}

	public static int LCM(int a, int b) {

		return (a * b / Euclid.GCD(a, b));
	}
}
