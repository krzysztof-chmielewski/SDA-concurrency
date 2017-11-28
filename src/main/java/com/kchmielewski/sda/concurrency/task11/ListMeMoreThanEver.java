package com.kchmielewski.sda.concurrency.task11;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListMeMoreThanEver {
    public List<Integer> createSquaresList(int n) {
        List<Integer> result = new CopyOnWriteArrayList<>();
        List<Integer> numbers = IntStream.range(0, n).boxed().collect(Collectors.toList());

        numbers.forEach(i -> new Thread(() -> result.add(i * i)).start());

        return result;
    }
}
