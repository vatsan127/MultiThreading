package com.srivatsan.multithreading.executor;

import java.util.concurrent.*;

public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        ExecutorService service = Executors.newFixedThreadPool(2);
        Callable<Integer> callable = () -> {
            Thread.sleep(2000);
            return 12;
        };
        Future<Integer> submit = service.submit(callable);
        System.out.println("isCancelled: "+ submit.isCancelled());
        System.out.println(submit.get(5, TimeUnit.SECONDS));
        System.out.println(" Main Thread Execution is completed");
        System.out.println("isDone: "+ submit.isDone());
        service.shutdown();
    }
}
