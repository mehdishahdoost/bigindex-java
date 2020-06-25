package com.github.java.util;

/**
 * @author Mehdi Shahdoost
 */
public class PrimeUtil {

    public static boolean isPrime(long number) {
        if (number <= 2) {
            return true;
        }

        for (long i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
