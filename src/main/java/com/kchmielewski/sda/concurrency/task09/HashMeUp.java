package com.kchmielewski.sda.concurrency.task09;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMeUp {
    public Map<Integer, Integer> createSquaresMap(int n) {
        Map<Integer, Integer> result = new HashMap<>();

        List<Thread> threads = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            int finalI = i;
            threads.add(new Thread(() -> result.put(finalI, finalI * finalI)));
            threads.get(i).start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return result;
    }
}
