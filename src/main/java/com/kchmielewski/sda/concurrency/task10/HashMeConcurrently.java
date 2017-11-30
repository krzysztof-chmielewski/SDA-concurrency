package com.kchmielewski.sda.concurrency.task10;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class HashMeConcurrently {
    public Map<Integer, Integer> createSquaresMap(int n) {
        Map<Integer, Integer> result = new ConcurrentHashMap<>();

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
