package com.kchmielewski.sda.concurrency.task06;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class IncrementMeTest {
    @Test
    public void thisIsDefinitelyWrongAssumption() throws Exception {
        assertThat(new IncrementMe().incrementMeALot(100000)).isEqualTo(100000);
    }
}