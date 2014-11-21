/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fibonacci;

/**
 *
 * @author yaroslav.hulaga
 */
public class FibonacciAdvanced {

	public static long calc(int n) {
		if (n < 2) {
			return n;
		}

		long[] f = new long[n];
		f[0] = 1;
		f[1] = 1;
		for (int i = 2; i < n; i++) {
			f[i] = f[i - 2] + f[i - 1];
		}
		// System.out.println(Arrays.toString(f));
		return f[n - 1];

	}
}
