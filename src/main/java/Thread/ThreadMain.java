package Thread;

public class ThreadMain {
    public static void main(String[] args) {

        // Create Thread with Extends Keyword
        MyThread myThread = new MyThread();
        myThread.start();

        // Create Thread with Implements
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();

        // Create Thread with Runnable and Lambda
        Runnable runnable = () -> {
            System.out.println("Lambda Thread run, ThreadName: " + Thread.currentThread().getName());
        };
        Thread thread1 = new Thread(runnable);
        thread1.start();
    }
}
