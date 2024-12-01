package threads;

public class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("MyRunnable run, ThreadName: " + Thread.currentThread().getName());
    }
}
