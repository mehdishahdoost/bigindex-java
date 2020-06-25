package com.github.java.lang.thread.daemon;

import java.util.Date;
import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * @author Mehdi Shahdoost
 */
public class CleanerTask extends Thread {

    private Deque<Event> deque;

    public CleanerTask(Deque<Event> deque) {
        this.deque = deque;
        setDaemon(true);
    }

    @Override
    public void run() {
        while (true) {
            Date date = new Date();
            clean(date);
        }
    }

    private void clean(Date date) {
        if (deque.size() == 0) {
            return;
        }

        long difference = 0;
        boolean delete = false;

        do {
            Event first = deque.getFirst();
            difference = date.getTime() - first.getDate().getTime();
            if (difference > 100000) {
                System.out.printf("%s \n", first.getEvent());
                deque.removeLast();
                delete = true;
            }
        } while (difference > 10000);

        if (delete) {
            System.out.printf("Cleaner: size of queue: %d\n", deque.size());
        }

    }

    public static void main(String[] args) {
        Deque<Event> eventsQueue = new ConcurrentLinkedDeque<>();
        WriterTask writerTask = new WriterTask(eventsQueue);

        for (int i = 0; i < Runtime.getRuntime().availableProcessors(); i++) {
            Thread thread = new Thread(writerTask);
            thread.start();
        }

        CleanerTask cleanerTask = new CleanerTask(eventsQueue);
        cleanerTask.start();
    }
}
