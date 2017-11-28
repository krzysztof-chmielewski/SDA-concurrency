package com.kchmielewski.sda.concurrency.task02;

import java.util.Arrays;
import java.util.List;

public class DisplayMeMore {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        for (Integer integer : numbers) {
            new Thread(() -> System.out.println(integer)).start();
        }

        numbers.stream().forEach(i -> new Thread(() -> System.out.println(i)).start());

        numbers.forEach(i -> new Thread(() -> System.out.println(i)).start());
    }
}
