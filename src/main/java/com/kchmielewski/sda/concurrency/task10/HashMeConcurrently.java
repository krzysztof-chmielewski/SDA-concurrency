package com.kchmielewski.sda.concurrency.task10;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class HashMeConcurrently {
    public Map<Integer, Integer> createSquaresMap(int n) {
        Map<Integer, Integer> result = new ConcurrentHashMap<>();
        List<Integer> numbers = IntStream.range(0, n).boxed().collect(Collectors.toList());

        numbers.forEach(i -> new Thread(() -> result.put(i, i * i)).start());

        return result;
    }
}
