package com.srivatsan.multithreading.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPool {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
            Thread.sleep(1000L);
            service.execute(new Task(i));
        }
        service.shutdown();
    }
}
