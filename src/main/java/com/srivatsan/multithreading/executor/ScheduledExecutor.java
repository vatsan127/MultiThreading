package com.srivatsan.multithreading.executor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutor {
    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
        Integer i = 0;
        service.scheduleAtFixedRate(new Task(i), 1000, 2000, TimeUnit.MILLISECONDS);
        try {
            if (!service.awaitTermination(6000,TimeUnit.MILLISECONDS)){
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            service.shutdownNow();
            throw new RuntimeException(e);
        }

    }
}
