public class Main {

	private final int a;
	private int copy = getA();

	public Main() {
		a = 10;
	}

	public int getA() {
		return a;
	}

	public int getCopy() {
		return copy;
	}

	public static void main(String[] args) {
		NullTest nt = null;
		System.out.println(nt.getInt());

		Main m = new Main();
		System.out.println(m.getA());
		System.out.println(m.getCopy());

		System.out.println(nt == null);

	}

}
