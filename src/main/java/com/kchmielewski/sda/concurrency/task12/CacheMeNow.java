package com.kchmielewski.sda.concurrency.task12;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CacheMeNow {
    private final Map<Integer, List<Integer>> cache = new HashMap<>();

    public List<Integer> createSquaresList(int n) {
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        List<Integer> result = new CopyOnWriteArrayList<>();
        List<Integer> numbers = IntStream.range(0, n).boxed().collect(Collectors.toList());

        numbers.forEach(i -> new Thread(() -> result.add(i * i)).start());

        cache.put(n, result);

        return result;
    }
}
