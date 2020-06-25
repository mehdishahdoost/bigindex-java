package com.github.java.lang.runnable;

/**
 * Two ways for creating thread:
 *
 * 1) class extends Thread class and override run() method. and call start() method of this class.
 *
 * 2) class implements Runnable interface and implements run() method and after that pass this class to constructor of
 * Thread class and call start() method
 *
 * @author Mehdi Shahdoost
 */
public class Calculator implements Runnable {

    public void run() {

        long current = 1;
        long max = 20000;
        long numPrimes = 0;

        System.out.printf("Thread '%s': Start\n", Thread.currentThread().getName());

        while (current <= max) {
            if (isPrime(current)) {
                numPrimes++;
            }
            current++;
        }

        System.out.printf("Thread '%s' End. Number of primes %d\n", Thread.currentThread().getName(), numPrimes);
    }


    private boolean isPrime(long number) {
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
