package com.kchmielewski.sda.concurrency.task22;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class ChangingListWithFutureTest {
    @Test
    public void firstHalfIsMultipliedAndSecondIsReduced() throws Exception {
        ChangingListWithFuture futureChange = new ChangingListWithFuture();
        List<Integer> parameter = Arrays.asList(1, 2, 3, 4, 5, 6);

        assertThat(futureChange.changeMe(parameter)).containsExactly(5, 10, 15, -1, 0, 1);
    }

}