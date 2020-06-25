package com.github.java.lang.runnable;

/**
 *
 * Two ways for creating thread:
 *
 * 1) class extends Thread class and override run() method. and call start() method of this class.
 *
 * 2) class implements Runnable interface and implements run() method and after that pass this class to constructor of
 * Thread class and call start() method
 *
 * @author Mehdi Shahdoost
 */
public class PrinterThread extends Thread {

    @Override
    public void run() {
        System.out.printf("Thread: id: %s", Thread.currentThread().getName() + "\n");
    }

    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            PrinterThread printerThread = new PrinterThread();
            printerThread.setName("Thread" + i);
            if (i % 2 == 0) {
                printerThread.setPriority(Thread.MAX_PRIORITY);
            }
            printerThread.start();
        }
    }

}
