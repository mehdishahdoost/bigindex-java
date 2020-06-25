package com.github.java.lang.thread.interrupted;

import com.github.java.lang.thread.util.PrimeUtil;

/**
 *
 * It's easy way to interrupted  a thread with calling interrupt method
 *
 * @author Mehdi Shahdoost
 */
public class PrimeGenerator extends Thread {

    @Override
    public void run() {

        long number = 1;

        while (true) {
            if (PrimeUtil.isPrime(number)) {
                System.out.printf("Number %s is prime \n", number);
            }

            if (isInterrupted()) {
                System.out.printf("The primeGenerator is interrupted\n");
                return;
            }

            number++;
        }
    }

    public static void main(String[] args) {

        Thread task = new PrimeGenerator();
        task.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        task.interrupt();

        System.out.printf("Main: task status: %s\n", task.getState());
        System.out.printf("Main: task is interrupted: %s\n", task.isInterrupted());
        System.out.printf("Main: task is alive: %s\n", task.isAlive());

    }
}
