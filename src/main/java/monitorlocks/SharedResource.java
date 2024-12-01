package monitorlocks;

public class SharedResource {

    public synchronized void addItems() {
        System.out.println("add items : Lock Acquired : ThreadName = " + Thread.currentThread().getName());
        try {
            System.out.println(Thread.currentThread().getName() + " : sleeping for 8 seconds");
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized void removeItems() {
        System.out.println("removeItems : Lock Acquired : ThreadName = " + Thread.currentThread().getName());
        try {
            System.out.println(Thread.currentThread().getName() + " : sleeping for 8 seconds");
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
