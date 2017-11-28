package com.kchmielewski.sda.concurrency.test06;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class IncrementMeTest {
    @Test
    public void thisIsDefinitelyWrongAssumption() throws Exception {
        assertThat(new IncrementMe().incrementMeALot(1000)).isEqualTo(1000);
    }
}