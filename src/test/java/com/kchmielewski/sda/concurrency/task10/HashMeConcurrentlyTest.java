package com.kchmielewski.sda.concurrency.task10;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HashMeConcurrentlyTest {
    @Test
    public void thisTimeItWillPass() throws Exception {
        assertThat(new HashMeConcurrently().createSquaresMap(10000)).hasSize(10000);
    }
}