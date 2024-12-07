package Locks.Conditions;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void produce() {
        String threadName = Thread.currentThread().getName();
        try {
            lock.lock();
            System.out.println("Lock Acquired By - " + threadName);
            System.out.println(threadName + ", waiting! ");
            condition.await();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
            System.out.println("Lock Release By - " + threadName);
        }
    }

    public void consume() {
        String threadName = Thread.currentThread().getName();
        try {
            lock.lock();
            System.out.println("Lock Acquired By - " + threadName);
            Thread.sleep(3 * 1000);
            condition.signal();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("Lock Release By - " + threadName);
            lock.unlock();
        }
    }

}
