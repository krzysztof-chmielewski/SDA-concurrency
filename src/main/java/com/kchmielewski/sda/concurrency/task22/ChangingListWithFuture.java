package com.kchmielewski.sda.concurrency.task22;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

public class ChangingListWithFuture {
    public List<Integer> changeMe(List<Integer> integers) {
        List<Integer> firstHalf = integers.subList(0, integers.size() / 2);
        List<Integer> secondHalf = integers.subList(integers.size() / 2, integers.size());

        ExecutorService executorService = Executors.newCachedThreadPool();

        Future<List<Integer>> firstHalfFuture = executorService.submit(
                () -> firstHalf.stream().map(i -> i * 5).collect(Collectors.toList()));
        Future<List<Integer>> secondHalfFuture = executorService.submit(
                () -> secondHalf.stream().map(i -> i - 5).collect(Collectors.toList()));

        try {
            List<Integer> firstHalfResult = firstHalfFuture.get();
            List<Integer> secondHalfResult = secondHalfFuture.get();
            List<Integer> result = new ArrayList<>(firstHalfResult);
            result.addAll(secondHalfResult);
            return result;
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        return Collections.emptyList();
    }
}
