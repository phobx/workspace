public class QE {
	public static Complex[] solveQE(double a, double b, double c) {

		if (a == 0) {
			System.out.println("Equation is linear.");
			return new Complex[] { new Complex(-c / b, 0) };

		}

		// ax^2 + bx + c = 0 => x^2 + 2px + q = 0
		double p = b / (2 * a);
		double q = c / a;
		double d = p * p - q;

		if (d < 0) {
			System.out.println("Quadratic equation has 2 complex roots.");
			return new Complex[] { new Complex(-p, Math.sqrt(-d)),
					new Complex(-p, -Math.sqrt(-d)) };

		} else if (d > 0) {
			System.out.println("Quadratic equation has 2 roots.");
			return new Complex[] { new Complex(-p + Math.sqrt(d), 0),
					new Complex(-p - Math.sqrt(d), 0) };
		}

		System.out.println("Quadratic equation has 1 root.");
		return new Complex[] { new Complex(-p, 0) };

	}

	public static void printRoots(Complex[] roots) {
		for (int i = 0; i < roots.length; i++) {
			System.out.println("X" + (i + 1) + " = " + roots[i]);
		}
	}
}
