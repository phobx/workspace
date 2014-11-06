public class Complex {
	public Complex(double real, double imag) {
		this.re = real;
		this.im = imag;
	}

	public String toString() {
		if (im == 0)
			return re + "";
		if (re == 0)
			return im + "i";
		if (im < 0)
			return re + " - " + (-im) + "i";
		return re + " + " + im + "i";

	}

	private final double re;
	private final double im;
}
