package com.srivatsan.multithreading.runnable;

public class MyRunnableThreads {
    public static void main(String[] args) {
        Thread threadOne = new Thread(new ThreadOne());
        Thread threadTwo = new Thread(new ThreadTwo());

        threadOne.start();
        threadTwo.start();
    }
}

class ThreadOne implements Runnable {
    public void run() {
        for (int i = 0; i < 15; i++) {
            System.out.println("ThreadOne : " + i);
        }
    }
}


class ThreadTwo implements Runnable {
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("ThreadTwo : " + i);
        }
    }
}