package com.github.java.lang.thread.interrupted;

import org.w3c.dom.ls.LSOutput;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 *
 * Another way to interrupt a thread is using InterruptedException
 *
 * @author Mehdi Shahdoost
 */
public class FileSearch implements Runnable {

    private String initPath;
    private String fileName;

    public FileSearch(String initPath, String fileName) {
        this.initPath = initPath;
        this.fileName = fileName;
    }

    @Override
    public void run() {
        File file = new File(initPath);
        if (file.isDirectory()) {
            try {
                directoryProcess(file);
            } catch (InterruptedException ex) {
                System.out.printf("%s : The search has been interrupted",
                        Thread.currentThread().getName());
            }
        }
    }

    private void directoryProcess(File file) throws InterruptedException {
        File[] files = file.listFiles();
        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                if (files[i].isDirectory()) {
                    directoryProcess(files[i]);
                } else {
                    fileProcess(files[i]);
                }
            }
        }

        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
    }

    private void fileProcess(File file) throws InterruptedException {
        if (file.getName().equals(fileName)) {
            System.out.printf("%s : %s\n", Thread.currentThread().getName(), file.getAbsolutePath());
        }

        if(Thread.interrupted()) {
            throw new InterruptedException();
        }
    }

    public static void main(String[] args) {

        FileSearch fileSearch = new FileSearch("/home/shahdoost", "mvnw");
        Thread thread = new Thread(fileSearch);
        thread.start();

        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread.interrupt();


    }

}
