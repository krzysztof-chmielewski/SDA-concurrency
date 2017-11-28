package com.kchmielewski.sda.concurrency.task03;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamMe {
    public static void main(String[] args) {
        Stream<Integer> numbers1 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        numbers1.forEach(i -> new Thread(() -> System.out.println(i)).start());

        Stream<Integer> numbers2 = IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).boxed();
        numbers2.forEach(i -> new Thread(() -> System.out.println(i)).start());

        Stream<Integer> numbers3 = IntStream.range(1, 11).boxed();
        numbers3.forEach(i -> new Thread(() -> System.out.println(i)).start());

        Stream<Integer> numbers4 = IntStream.rangeClosed(1, 10).boxed();
        numbers4.forEach(i -> new Thread(() -> System.out.println(i)).start());
    }
}
