package com.srivatsan.multithreading.basic;

public class DaemonUserThreads {
    public static void main(String[] args) {
        Thread dmThread = new Thread(new DaemonHelper());
        Thread userThread = new Thread(new UserHelper());
        dmThread.setDaemon(true);
        dmThread.start();
        userThread.start();

    }
}


class DaemonHelper implements Runnable {

    @Override
    public void run() {
        int counter = 0;
        while (counter < 500) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            counter++;
            System.out.println("Daemon Helper Running");
        }
    }
}

class UserHelper implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("User Helper Done with Execution");
    }
}
