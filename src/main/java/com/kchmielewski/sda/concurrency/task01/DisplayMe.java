package com.kchmielewski.sda.concurrency.task01;

public class DisplayMe {
    public static void main(String[] args) {
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        };
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });
        Thread thread3 = new Thread(() -> System.out.println(Thread.currentThread().getName()));

        System.out.println(Thread.currentThread().getName());
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
