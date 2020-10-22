package ru.itmo;

public class MyThread extends Thread {
    private Object lock;

    public MyThread(Object object) {
        this.lock = object;
    }
    
    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
                try {
                    System.out.println(getName());
                    lock.notify();
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
