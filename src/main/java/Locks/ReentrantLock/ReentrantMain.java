package Locks.ReentrantLock;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantMain {
    public static void main(String[] args) {

        ReentrantLock lock = new ReentrantLock();

        SharedResource resource1 = new SharedResource();
        Thread t1 = new Thread(() -> resource1.printThread(lock));

        SharedResource resource2 = new SharedResource();
        Thread t2 = new Thread(() -> resource2.printThread(lock));

        t1.start();
        t2.start();
    }
}
