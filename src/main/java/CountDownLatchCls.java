import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class CountDownLatchCls {

    private class Task implements Runnable {

        private final CountDownLatch latch;

        public Task(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            System.out.println(String.format("ThreadName - '%s', count - '%d'", Thread.currentThread().getName(), latch.getCount()));
            latch.countDown();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatchCls cls = new CountDownLatchCls();
        cls.startCountDownLatch();
    }

    public void startCountDownLatch() throws InterruptedException {
        int taskSize = 3;
        CountDownLatch latch = new CountDownLatch(taskSize);
        ExecutorService service = Executors.newFixedThreadPool(taskSize);
        for (int i = 0; i < taskSize; i++) {
            service.submit(new Task(latch));
        }
        latch.await();
        service.shutdown();
        System.out.println("Main Thread Execution Done");
    }
}
