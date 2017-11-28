package com.kchmielewski.sda.concurrency.task08;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class IncrementMeAtomicallyTest {
    @Test
    public void incrementingByGivenNumberReturnsTheSame() throws Exception {
        assertThat(new IncrementMeAtomically().incrementMeALot(100000)).isEqualTo(100000);
    }

}