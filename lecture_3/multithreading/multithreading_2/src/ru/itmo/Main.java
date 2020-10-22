package ru.itmo;

public class Main {

    public static void main(String[] args) {
        MyThread thread = new MyThread();
        System.out.println(thread.getState());

        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(thread.getState());
    }
}
