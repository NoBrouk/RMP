package ru.itmo;

public class Main {

    public static void main(String[] args) {
        Counter counter = new Counter();

        for (int i = 0; i < 100; i++) {
            new MyThread(counter).start();
        }
    }
}
