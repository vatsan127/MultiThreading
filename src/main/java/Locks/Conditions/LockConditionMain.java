package Locks.Conditions;

public class LockConditionMain {

    /* Condition
     *       await = wait
     *       signal = notify
     * */

    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        Thread t1 = new Thread(resource::produce);
        Thread t2 = new Thread(resource::consume);

        t1.setName("Producer Thread");
        t2.setName("Consumer Thread");

        t1.start();
        t2.start();

    }
}
