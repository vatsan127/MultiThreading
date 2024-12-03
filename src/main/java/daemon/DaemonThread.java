package daemon;

public class DaemonThread {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            try {
                System.out.println("Daemon thread is running...");
                Thread.sleep(5000); // 5 sec
                System.out.println("Daemon thread is done executing...");
            } catch (InterruptedException e) {

            }
        };

        System.out.println("Main thread is running...");
        Thread daemonThread = new Thread(runnable);
        daemonThread.setDaemon(true);
        daemonThread.start();

        Thread.sleep(3000); // 3 sec
        System.out.println("Main thread has finished execution.");
    }
}
