package com.github.java.lang.thread.exception;

/**
 * @author Mehdi Shahdoost
 */
public class Task implements Runnable {
    @Override
    public void run() {
        int i = Integer.parseInt("TTT");
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new Task());
        thread.setUncaughtExceptionHandler(new ExceptionHandler());
        thread.start();
    }
}
