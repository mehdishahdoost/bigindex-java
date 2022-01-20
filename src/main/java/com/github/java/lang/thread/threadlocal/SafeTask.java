package com.github.java.lang.thread.threadlocal;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author Mehdi Shahdoost
 */
public class SafeTask implements Runnable {

    private ThreadLocal<Date> startDate = new ThreadLocal<Date>() {
        @Override
        protected Date initialValue() {
            return new Date();
        }
    };

    @Override
    public void run() {
        System.out.printf("Starting Thread: %s : %s \n",
                Thread.currentThread().getId(), startDate.get());
        try {
            TimeUnit.SECONDS.sleep((int) Math.rint(Math.random() * 10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Finished Thread: %s : %s \n",
                Thread.currentThread().getId(), startDate.get());
    }
}

