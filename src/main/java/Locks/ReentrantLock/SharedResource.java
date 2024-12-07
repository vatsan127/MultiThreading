package Locks.ReentrantLock;

import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {

    public void printThread(ReentrantLock lock) {
        boolean isAvailable = lock.tryLock();
        String threadName = Thread.currentThread().getName();
        try {
            if (isAvailable) {
                System.out.println("AcquriedLock, ThreadName - " + threadName);
                Thread.sleep(5 * 1000);
            } else {
                System.out.println("Lock Not Available, Threadname - " + threadName);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            if (isAvailable) {
                lock.unlock();
                System.out.println("Lock Released by " + threadName);
            }
        }
    }

}
