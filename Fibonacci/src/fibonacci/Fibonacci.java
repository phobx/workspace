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
public class Fibonacci {

    public static long calc(int n) {
        if (n < 2) {
            return n;
        }
        return calc(n - 1) + calc(n - 2);
    }
}
