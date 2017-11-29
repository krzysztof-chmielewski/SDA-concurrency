package com.kchmielewski.sda.concurrency.task12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public class CacheMeNow {
    private final Map<Integer, List<Integer>> cache = new HashMap<>();

    public List<Integer> createSquaresList(int n) {
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        List<Integer> result = new CopyOnWriteArrayList<>();

        List<Thread> threads = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            int finalI = i;
            threads.add(new Thread(() -> result.add(finalI * finalI)));
            threads.get(i).start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        cache.put(n, result);

        return result;
    }
}
