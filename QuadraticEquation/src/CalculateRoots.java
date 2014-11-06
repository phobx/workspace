public class CalculateRoots {
	public static void main(String[] args) {
		double a = 1;
		double b = 2;
		double c = 5;

		System.out.println("\na = " + a + "; b = " + b + "; c = " + c + ";");
		QE.printRoots(QE.solveQE(a, b, c));

		a = 0;
		b = 2;
		c = -6;

		System.out.println("\na = " + a + "; b = " + b + "; c = " + c + ";");
		QE.printRoots(QE.solveQE(a, b, c));

		a = -1;
		b = 2;
		c = -5;

		System.out.println("\na = " + a + "; b = " + b + "; c = " + c + ";");
		QE.printRoots(QE.solveQE(a, b, c));

		a = -1.5;
		b = 2;
		c = 10;

		System.out.println("\na = " + a + "; b = " + b + "; c = " + c + ";");
		QE.printRoots(QE.solveQE(a, b, c));
	}
}
