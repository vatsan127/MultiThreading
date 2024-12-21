import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierCls {

    private class Tourist implements Runnable {

        private final int touristId;

        private final CyclicBarrier latch;

        public Tourist(int touristId, CyclicBarrier latch) {
            this.latch = latch;
            this.touristId = touristId;
        }

        @Override
        public void run() {
            try {
                for (int i = 0; i < NUM_OF_STAGES; i++) {
                    Thread.sleep(1_000);
                    System.out.println(String.format("Index - %d, Stage - %d ThreadName - %s, Execution Done", touristId, tourStage, Thread.currentThread().getName()));
                    latch.await();
                }
            } catch (InterruptedException | BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static final int NUM_TOURIST = 5;
    private static final int NUM_OF_STAGES = 3;
    private static int tourStage = 0;

    private final CyclicBarrier latch = new CyclicBarrier(NUM_TOURIST, () -> System.out.println("Starting Next Stage - " + ++tourStage));

    private void startCyclicBarrier() {
        for (int i = 0; i < NUM_TOURIST; i++) {
            Thread tourist = new Thread(new Tourist(i, latch));
            tourist.start();
        }
    }

    public static void main(String[] args) {
        CyclicBarrierCls cls = new CyclicBarrierCls();
        cls.startCyclicBarrier();
        System.out.println("Main Thread Execution Done");
    }
}
