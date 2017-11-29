package com.kchmielewski.sda.concurrency.task15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class PreventingChanges {
    private final Map<Integer, List<Integer>> cache = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        PreventingChanges preventingChanges = new PreventingChanges();
        List<Integer> firstComputation = preventingChanges.createSquaresList(5);
        System.out.println(firstComputation);
        firstComputation.clear();
        List<Integer> secondComputation = preventingChanges.createSquaresList(5);
        System.out.println(firstComputation);
        System.out.println(secondComputation);
    }

    public List<Integer> createSquaresList(int n) {
        return cache.computeIfAbsent(n, (list) -> {
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

            return Collections.unmodifiableList(result);
        });
    }
}
