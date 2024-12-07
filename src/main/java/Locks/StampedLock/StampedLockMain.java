package Locks.StampedLock;

public class StampedLockMain {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        Thread t1 = new Thread(() -> resource.consume());
        Thread t2 = new Thread(() -> resource.produce());

        t1.setName("ReadThread");
        t2.setName("WriteThread");

        t1.start();
        t2.start();
    }
}
