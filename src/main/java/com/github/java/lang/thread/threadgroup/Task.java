package com.github.java.lang.thread.threadgroup;

import java.util.Random;

/**
 * @author Mehdi Shahdoost
 */
public class Task implements Runnable {

    @Override
    public void run() {
        int result;
        Random random = new Random(Thread.currentThread().getId());
        while (true) {
            result = 1000 / ((int) (random.nextDouble() * 1000000000));
            if (Thread.currentThread().isInterrupted()) {
                System.out.printf("%d : Interrupted\n",
                        Thread.currentThread().getId());
                return;
            }
        }
    }

    public static void main(String[] args) {
        int numberOfThreads = 2 * Runtime.getRuntime().availableProcessors();
        MyThreadGroup myThreadGroup = new MyThreadGroup("MYTHREAD");

        for(int i=0; i<numberOfThreads; i++) {
            Task task = new Task();
            Thread thread = new Thread(myThreadGroup, task);
            thread.start();
        }

        System.out.printf("Number of Threads: %d\n",
                myThreadGroup.activeCount());
        System.out.printf("Information about the Thread Group\n");
        myThreadGroup.list();

        Thread[] threads = new Thread[myThreadGroup.activeCount()];
        myThreadGroup.enumerate(threads);
        for (int i = 0; i < myThreadGroup.activeCount(); i++) {
            System.out.printf("Thread %s: %s\n", threads[i].getName(),
                    threads[i].getState());
        }

    }
}
