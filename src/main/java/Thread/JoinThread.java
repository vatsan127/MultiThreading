package Thread;

public class JoinThread {

    private static Thread t1 = new Thread(() -> {
        try {
            System.out.println("Thread - 1 , Started");
            Thread.sleep(8000);
            System.out.println("Thread - 1 , Completed");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    });

    private static Thread t2 = new Thread(() -> {
        try {
            System.out.println("Thread - 2 , Started");
            Thread.sleep(1000);
            System.out.println("Thread - 2 , Completed");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    });

    public static void main(String[] args) throws InterruptedException {
        t1.start();
        t2.start();

        t1.join();

        System.out.println("Main Thread Execution Done.");
    }
}
