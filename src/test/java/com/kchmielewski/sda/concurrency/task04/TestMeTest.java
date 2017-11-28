package com.kchmielewski.sda.concurrency.task04;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TestMeTest {
    @Test
    public void forEmptyListReturnsEmptyList() throws Exception {
        List<Integer> integers = Collections.emptyList();

        assertThat(new TestMe().changeMe(integers)).isEmpty();
    }

    @Test
    public void forTwoElementListFirstIsMultipliedAndSecondIsMultipliedAndInverted() throws Exception {
        List<Integer> integers = Arrays.asList(4, 3);

        assertThat(new TestMe().changeMe(integers)).containsExactly(16, -9);
    }

    @Test
    public void forOddNumberOfParametersMiddleOneIsInverted() throws Exception {
        List<Integer> integers = Arrays.asList(4, 3, 9);

        assertThat(new TestMe().changeMe(integers)).containsExactly(16, -9, -81);
    }
}