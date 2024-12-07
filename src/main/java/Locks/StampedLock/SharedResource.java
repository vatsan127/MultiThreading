package Locks.StampedLock;

import java.util.concurrent.locks.StampedLock;

public class SharedResource {

    private StampedLock lock = new StampedLock();
    private static String msg = "NoMessage";

    // Read Data
    public void consume() {
        long stamp = lock.tryOptimisticRead();
        try {
            System.out.println(String.format("Taken Optimistic Read Lock, Stamp - %s, ThreadName - %s", stamp, Thread.currentThread().getName()));
            String newMsg = "Consume";

            // Wait For the write Operations
            Thread.sleep(3000);

            if (lock.validate(stamp)) { // Update Only if the message is not changed
                System.out.println(String.format("Message Updated - '%s', ThreadName - %s", msg, Thread.currentThread().getName()));
            } else {
                System.out.println(String.format("Message RolledBack - %s, ThreadName - %s", newMsg, Thread.currentThread().getName()));
            }
        } catch (Exception e) {

        }
    }

    // Write Data
    public void produce() {
        long stamp = lock.writeLock();
        try {
            System.out.println(String.format("Taken Optimistic Write Lock, Stamp - %s, ThreadName - %s", stamp, Thread.currentThread().getName()));
            msg = "Produce";
        } finally {
            lock.unlockWrite(stamp);
            System.out.println(String.format("Message Updated - '%s', ThreadName - %s", msg, Thread.currentThread().getName()));
        }
    }

}
