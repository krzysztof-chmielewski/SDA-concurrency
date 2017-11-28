package com.kchmielewski.sda.concurrency.task08;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class IncrementMeAtomically {
    private AtomicInteger number = new AtomicInteger();

    public int incrementMeALot(int n) {
        List<Thread> threads = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            threads.add(new Thread(() -> number.incrementAndGet()));
            threads.get(i).start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return number.get();
    }
}
