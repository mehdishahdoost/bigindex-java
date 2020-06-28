package com.github.java.lang.thread.threadfactory;

import java.util.concurrent.TimeUnit;

/**
 * The ThreadFactory interface has only one method, called newThread() . It receives a
 * Runnable object as a parameter and returns a Thread object.
 * @author Mehdi Shahdoost
 */
public class MyTask implements Runnable {

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MyThreadFactory myThreadFactory = new MyThreadFactory("Threads-Test");
        MyTask myTask = new MyTask();
        Thread thread;
        System.out.println("Start threads");
        for (int i = 0; i < 10; i++) {
            thread = myThreadFactory.newThread(myTask);
            thread.start();
        }
        System.out.println("Stats");
        System.out.println(myThreadFactory.getStats());
    }
}
