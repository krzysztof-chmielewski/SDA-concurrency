package com.kchmielewski.sda.concurrency.task07;

import java.util.ArrayList;
import java.util.List;

public class SynchronizeMyMethod {
    private int number;

    public int incrementMeALot(int n) {
        List<Thread> threads = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            threads.add(new Thread(this::increment));
            threads.get(i).start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return number;
    }

    private synchronized void increment() {
        number++;
    }
}
