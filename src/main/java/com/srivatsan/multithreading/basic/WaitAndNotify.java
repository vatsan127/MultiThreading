package com.srivatsan.multithreading.basic;

public class WaitAndNotify {

    /* diff b/w wait and sleep is
        wait can be used for
        1. make a Thread wait until it is awakened
        2. Inter Thread communication

        sleep
        1. makes the thread sleep for a particular interval

     * notify() - can be used for awaken Thread that is waiting on the same lock Object
     * */

    private static final Object LOCK = new Object();

    public static void main(String[] args) {
        Thread one = new Thread(() -> {
            try {
                one();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread two = new Thread(() -> {
            try {
                two();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        one.start();
        two.start();
    }

    public static void one() throws InterruptedException {
        synchronized (LOCK) {
            System.out.println("hello from method one");
            LOCK.wait();
            System.out.println("back from method one");
        }
    }

    public static void two() throws InterruptedException {
        synchronized (LOCK) {
            System.out.println("hello from method two");
            LOCK.notify();
            System.out.println("message from method two");
        }
    }

}
