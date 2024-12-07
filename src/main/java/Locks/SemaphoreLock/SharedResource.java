package Locks.SemaphoreLock;

import java.util.concurrent.Semaphore;

public class SharedResource {

/*    ReentrantLock lock = new ReentrantLock();
    Condition condition = lock.newCondition();*/

    private Semaphore lock = new Semaphore(2);

    public void produce() {
        String threadName = Thread.currentThread().getName();
        try {
            lock.acquire();
            System.out.println("Lock Acquired By ThreadName - " + threadName);


            Thread.sleep(3 * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("Lock release by Thread - " + threadName);
            lock.release();
        }
    }

}
