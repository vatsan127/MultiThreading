package Locks.ReadWriteLock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteMain {

    public static void main(String[] args) throws InterruptedException {
        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        SharedResource resource = new SharedResource();

        // Write Threads
        Thread w1 = new Thread(() -> resource.producer(readWriteLock));
        Thread w2 = new Thread(() -> resource.producer(readWriteLock));

        // Read Threads
        Thread r1 = new Thread(() -> resource.consumer(readWriteLock));
        Thread r2 = new Thread(() -> resource.consumer(readWriteLock));

        w1.start();
        Thread.sleep(1000);

        r1.start();
        r2.start();

        w2.start();
    }
}
