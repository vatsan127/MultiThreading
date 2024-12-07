package Locks.SemaphoreLock;

public class SemaphoreLockMain {


    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        Thread t1 = new Thread(() -> resource.produce());
        Thread t2 = new Thread(() -> resource.produce());
        Thread t3 = new Thread(() -> resource.produce());
        Thread t4 = new Thread(() -> resource.produce());
        Thread t5 = new Thread(() -> resource.produce());
        Thread t6 = new Thread(() -> resource.produce());

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
    }

}
