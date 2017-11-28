package com.kchmielewski.sda.concurrency.task09;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HashMeUpTest {
    @Test
    public void thatAssumptionIsNotCorrect() throws Exception {
        assertThat(new HashMeUp().createSquaresMap(10000)).hasSize(10000);
    }
}