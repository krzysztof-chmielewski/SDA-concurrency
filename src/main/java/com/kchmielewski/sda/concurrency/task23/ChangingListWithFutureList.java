package com.kchmielewski.sda.concurrency.task23;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class ChangingListWithFutureList {
    public List<Integer> changeMe(List<Integer> integers) {
        List<Integer> firstHalf = integers.subList(0, integers.size() / 2);
        List<Integer> secondHalf = integers.subList(integers.size() / 2, integers.size());

        ExecutorService executorService = Executors.newCachedThreadPool();

        try {
            List<Future<Integer>> firstHalfFuture = executorService.invokeAll(
                    firstHalf.stream().map(i -> (Callable<Integer>) () -> i * 5).collect(Collectors.toList()));
            List<Future<Integer>> secondHalfFuture = executorService.invokeAll(
                    secondHalf.stream().map(i -> (Callable<Integer>) () -> i - 5).collect(Collectors.toList()));

            List<Integer> result = new ArrayList<>(firstHalf.size() + secondHalf.size());
            for (Future<Integer> future : firstHalfFuture) {
                result.add(future.get());
            }
            for (Future<Integer> future : secondHalfFuture) {
                result.add(future.get());
            }

            return result;
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        return Collections.emptyList();
    }
}
