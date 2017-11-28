package com.kchmielewski.sda.concurrency.task14;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ComputeMeIfIAmAbsent {
    private final Map<Integer, List<Integer>> cache = new ConcurrentHashMap<>();

    public List<Integer> createSquaresList(int n) {
        return cache.computeIfAbsent(n, (list) -> {
            List<Integer> result = new CopyOnWriteArrayList<>();
            List<Integer> numbers = IntStream.range(0, n).boxed().collect(Collectors.toList());

            numbers.forEach(i -> new Thread(() -> result.add(i * i)).start());
            System.out.println(hashCode());

            return result;
        });
    }
}
