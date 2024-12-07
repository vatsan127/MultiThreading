package Locks.MonitorLock;

public class MonitorLocks {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();

        Thread t1 = new Thread(() -> sharedResource.addItems());
        Thread t2 = new Thread(() -> sharedResource.removeItems());

        t1.start();
        t2.start();

        System.out.println("Main Thread Execution done.");
    }
}
