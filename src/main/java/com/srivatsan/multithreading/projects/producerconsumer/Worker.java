package com.srivatsan.multithreading.projects.producerconsumer;

import java.util.Stack;

public class Worker {
    private int sequence = 0;
    private final Integer top;
    private final Integer bottom;
    private final Stack<Integer> container;

    public Worker(Integer top, Integer bottom) {
        this.top = top;
        this.bottom = bottom;
        this.container = new Stack<>();
    }

    private final Object lock = new Object();


    public void produce () throws InterruptedException {
        synchronized (lock){
            while (true){
                if(container.size() == top){
                    System.out.println("Container is full, waiting for items to be removed ");
                    lock.wait();
                }
                else {
                    System.out.println(sequence+ " Added to the container");
                    container.add(sequence);
                    sequence++;
                    lock.notify();
                }
                Thread.sleep(500);

            }
        }
    }
    public void consume () throws InterruptedException {
        synchronized (lock){
            while (true){
                if(container.size() == bottom){
                    System.out.println("container is empty, waiting for items to be added...");
                    lock.wait();
                }
                else {
                    System.out.println(container.pop()+ "  removed from container...");
                    lock.notify();
                }
                Thread.sleep(500);

            }
        }
    }

}
