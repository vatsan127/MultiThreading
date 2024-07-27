package com.srivatsan.multithreading.extendThread;

public class MyExtendThreads {
    public static void main(String[] args) {
        Thread threadOne = new ThreadOne();
        Thread threadTwo = new ThreadTwo();
        threadOne.start();
        threadTwo.start();
    }
}

class ThreadOne extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 15; i++) {
            System.out.println("ThreadOne " + i);
        }
    }
}

class ThreadTwo extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 15; i++) {
            System.out.println("ThreadTwo " + i);
        }
    }
}
