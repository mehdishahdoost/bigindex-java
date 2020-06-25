package com.github.java.lang.thread.simple;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

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
public class CalculatorApp {

    public static void main(String[] args) {

        System.out.printf("Minimum Priority: %s\n", Thread.MIN_PRIORITY);
        System.out.printf("Maximum Priority: %s\n", Thread.MAX_PRIORITY);
        System.out.printf("Normal Priority: %s\n", Thread.NORM_PRIORITY);

        Thread[] threads = new Thread[10];
        Thread.State[] states = new Thread.State[10];

        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new Calculator());
            if (i % 2 == 0) {
                threads[i].setPriority(Thread.MAX_PRIORITY);
            } else {
                threads[i].setPriority(Thread.MIN_PRIORITY);
            }
            threads[i].setName("My Thread " + i);
        }

        try (FileWriter fileWriter = new FileWriter("/tmp/log.txt");
             PrintWriter printWriter = new PrintWriter(fileWriter);) {
            for (int i = 0; i < 10; i++) {
                printWriter.println("Main: Status of Thread" + i + ": " + threads[i].getState());
                states[i] = threads[i].getState();
            }

            for (int i = 0; i < 10; i++) {
                threads[i].start();
            }

            boolean finish = false;

            while (!finish) {
                for (int i = 0; i < 10; i++) {
                    if (threads[i].getState() != states[i]) {
                        writeThreadInfo(printWriter, threads[i], states[i]);
                        states[i] = threads[i].getState();
                    }
                }

                finish = true;
                for (int i = 0; i < 10; i++) {
                    finish = finish && (threads[i].getState() == Thread.State.TERMINATED);
                }
            }

        } catch (IOException exception) {
            System.out.println(exception);
        }


    }

    public static void writeThreadInfo(PrintWriter pw, Thread thread, Thread.State state) {
        pw.printf("Main : Id %d - %s\n", thread.getId(),
                thread.getName());
        pw.printf("Main : Priority: %d\n", thread.getPriority());
        pw.printf("Main : Old State: %s\n", state);
        pw.printf("Main : New State: %s\n", thread.getState());
        pw.printf("Main : ************************************\n");
    }

}
