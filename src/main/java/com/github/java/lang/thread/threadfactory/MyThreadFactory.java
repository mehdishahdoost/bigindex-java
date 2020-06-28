package com.github.java.lang.thread.threadfactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadFactory;
import java.util.stream.Collectors;

/**
 * The ThreadFactory interface has only one method, called newThread() . It receives a
 * Runnable object as a parameter and returns a Thread object.
 * @author Mehdi Shahdoost
 */
public class MyThreadFactory implements ThreadFactory {

    private String name;
    private int count;
    private List<String> statics;

    public MyThreadFactory(String name) {
        this.name = name;
        this.statics = new ArrayList<>();
        this.count = 0;
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r, name + "-Thread_" + count);
        count++;
        statics.add(String.format("Created Thread %d with name %s on %s",
                thread.getId(), thread.getName(), new Date()));
        return thread;
    }

    public String getStats() {
        return statics.stream().collect(Collectors.joining("\n"));
    }
}
