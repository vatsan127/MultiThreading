package com.srivatsan.multithreading.basic;


public class RunnableThreads {
    public static void main(String[] args) {
        Thread threadOne = new Thread(() -> {
            for (int i = 0; i < 25; i++) {
                System.out.println("Thread One : " + i);
            }
        });
        Thread threadTwo = new Thread(() -> {
            for (int i = 0; i < 25; i++) {
                System.out.println("Thread two : " + i);
            }
        });

        threadOne.start();
        threadTwo.start();
    }
}

