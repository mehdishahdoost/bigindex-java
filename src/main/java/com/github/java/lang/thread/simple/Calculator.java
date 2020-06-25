package com.github.java.lang.thread.simple;

import com.github.java.lang.thread.util.PrimeUtil;

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
            if (PrimeUtil.isPrime(current)) {
                numPrimes++;
            }
            current++;
        }

        System.out.printf("Thread '%s' End. Number of primes %d\n", Thread.currentThread().getName(), numPrimes);
    }



}
