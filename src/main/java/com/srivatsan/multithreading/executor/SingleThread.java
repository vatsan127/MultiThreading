package com.srivatsan.multithreading.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThread {
    public static void main(String[] args) {
        try {
            ExecutorService service = Executors.newSingleThreadExecutor();
            for (int i = 0; i < 5; i++) {
                service.execute(new Task(i));
            }
            service.shutdown();
            System.out.println("All tasks executed successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
