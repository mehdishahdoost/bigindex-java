package com.github.java.lang.thread.join;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author Mehdi Shahdoost
 */
public class NetworkConnectionLoader implements Runnable {


    @Override
    public void run() {
        System.out.printf("Network connection loading %s\n", new Date());

        try {
            TimeUnit.SECONDS.sleep(6);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Network connection has finished. %s\n", new Date());
    }
}
