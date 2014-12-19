package org.moduleWithTests;

/**
 * Hello world!
 * 
 */
public class MyMath {
	public int add (int a, int b){
		int res = a + b;
		if (res >= 4){
			return 4;
		}
		return res;
	}

	public int sub (int a, int b){
		int res = a - b;
		if (res >= 4){
			return 4;
		}
		if (res < 0){
			res = 0;
		}
		return res;
	}
}
