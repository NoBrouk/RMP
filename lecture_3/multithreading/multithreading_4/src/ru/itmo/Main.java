package ru.itmo;

public class Main {

    public static void main(String[] args) {
        Object lock = new Object();

        new MyThread(lock).start();
        new MyThread(lock).start();

    }
}
