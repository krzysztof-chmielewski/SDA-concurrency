package com.kchmielewski.sda.concurrency.task05;

import java.util.ArrayList;
import java.util.List;

public class TestMeNow {

    public List<Integer> changeMe(List<Integer> integers) {
        List<Integer> firstHalf = integers.subList(0, integers.size() / 2);
        List<Integer> secondHalf = integers.subList(integers.size() / 2, integers.size());

        Thread firstThread = new Thread(() -> {
            for (int i = 0; i < firstHalf.size(); i++) {
                firstHalf.set(i, firstHalf.get(i) * firstHalf.get(i));
            }
        });

        Thread secondThread = new Thread(() -> {
            for (int i = 0; i < secondHalf.size(); i++) {
                secondHalf.set(i, secondHalf.get(i) * -secondHalf.get(i));
            }
        });

        firstThread.start();
        secondThread.start();

        try {
            firstThread.join();
            secondThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<Integer> result = new ArrayList<>(firstHalf);
        result.addAll(secondHalf);

        return result;
    }
}
