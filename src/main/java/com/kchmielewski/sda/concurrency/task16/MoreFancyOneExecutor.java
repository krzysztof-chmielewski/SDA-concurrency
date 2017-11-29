package com.kchmielewski.sda.concurrency.task16;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class MoreFancyOneExecutor {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(8);

        IntStream.rangeClosed(1, 10).boxed().forEach(i -> executorService.submit(() -> System.out.println(i)));
    }
}
