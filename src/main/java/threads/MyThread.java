package threads;

public class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println("ExtendWith run, ThreadName: " + Thread.currentThread().getName());
    }

}
