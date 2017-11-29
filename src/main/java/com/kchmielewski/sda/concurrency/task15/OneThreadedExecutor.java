package com.kchmielewski.sda.concurrency.task15;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class OneThreadedExecutor {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        IntStream.rangeClosed(1, 10).boxed().forEach(i -> executorService.submit(() -> System.out.println(i)));
    }
}
