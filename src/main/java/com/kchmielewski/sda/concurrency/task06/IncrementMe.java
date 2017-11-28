package com.kchmielewski.sda.concurrency.task06;

public class IncrementMe {
    private int number;

    public int incrementMeALot(int n) {
        for (int i = 0; i < n; i++) {
            new Thread(() -> number++).start();
        }

        return number;
    }
}
