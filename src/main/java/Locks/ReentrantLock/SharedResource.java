package Locks.ReentrantLock;

import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {

    public void printThread(ReentrantLock lock) {
        try {
            System.out.println("ThreadName - " + Thread.currentThread().getName() + ", lock status: " + lock.isLocked());
            lock.lock();
            System.out.println("ThreadName - " + Thread.currentThread().getName() + ", lock status: " + lock.isLocked());
            Thread.sleep(5 * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

}
