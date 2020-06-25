package com.github.java.lang.thread.join;

import java.util.Date;

/**
 * @author Mehdi Shahdoost
 */
public class Loader {
    public static void main(String[] args) {
        DataSourcesLoader dataSourcesLoader = new DataSourcesLoader();
        Thread thread = new Thread(dataSourcesLoader, "DataSourceLoader");

        NetworkConnectionLoader networkConnectionLoader = new NetworkConnectionLoader();
        Thread thread1 = new Thread(networkConnectionLoader, "networkConnectionLoader");

        thread.start();
        thread1.start();

        try {
            thread.join();
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Main: Configuration has been loaded: %s\n", new Date());

    }
}
