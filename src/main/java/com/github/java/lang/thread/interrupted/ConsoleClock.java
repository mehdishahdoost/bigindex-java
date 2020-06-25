package com.github.java.lang.thread.interrupted;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author Mehdi Shahdoost
 */
public class ConsoleClock implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.printf("%s\n", new Date());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                System.out.printf("The ConsoleClock has been interrupted");
            }
        }
    }

    public static void main(String[] args) {
        ConsoleClock consoleClock = new ConsoleClock();
        Thread thread = new Thread(consoleClock);
        thread.start();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread.interrupt();
    }
}
