package Locks.ReadWriteLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;

public class SharedResource {

    // Write Lock
    public void producer(ReadWriteLock writeLock) {
        Lock lock = writeLock.writeLock();
        boolean lockStatus = false;
        try {
            lockStatus = lock.tryLock();
            if (lockStatus) {
                System.out.println("Write lock acquired!. ThreadName - " + Thread.currentThread().getName());
            } else {
                System.out.println("Write lock Not Available!. ThreadName - " + Thread.currentThread().getName());
            }
        } finally {
            if (lockStatus) {
                lock.unlock();
                System.out.println("Write Lock Released By Thread - " + Thread.currentThread().getName());
            }
        }
    }

    // Read Lock
    public void consumer(ReadWriteLock readLock) {
        Lock lock = readLock.readLock();
        boolean lockStatus = false;
        String threadName = Thread.currentThread().getName();
        try {
            lockStatus = lock.tryLock();
            String message = lockStatus ? "Read Lock Acquired!. ThreadName - " : "Read Lock Not Available. ThreadName - ";
            System.out.println(message + threadName);
        } finally {
            if (lockStatus) {
                System.out.println("Read Lock Released By Thread - " + threadName);
            }
        }
    }

}
