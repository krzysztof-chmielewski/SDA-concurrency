package com.kchmielewski.sda.concurrency.task23;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class ChangingListWithFutureListTest {
    @Test
    public void firstHalfIsMultipliedAndSecondIsReduced() throws Exception {
        ChangingListWithFutureList futureChange = new ChangingListWithFutureList();
        List<Integer> parameter = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20);

        assertThat(futureChange.changeMe(parameter)).containsExactly(5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
    }

}