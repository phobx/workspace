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
public class Run {

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {

		int i = 10;
		long startTime = System.nanoTime();
		System.out.println(i + " : " + FibonacciAdvanced.calc(i) + " (advanced method)");
		// FibonacciAdvanced.calc(i);
		long endTime = System.nanoTime();
		System.out.println(endTime - startTime);

		long startTime1 = System.nanoTime();
		System.out.println(i + " : " + Fibonacci.calc(i));
		// Fibonacci.calc(i);
		long endTime1 = System.nanoTime();
		System.out.println(endTime1 - startTime1);

	}

}
