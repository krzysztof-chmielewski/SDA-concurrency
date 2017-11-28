package com.kchmielewski.sda.concurrency.task07;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SynchronizeMyselfTest {
    @Test
    public void thisMayActuallyWorkThisTime() throws Exception {
        assertThat(new SynchronizeMyself().incrementMeALot(100000)).isEqualTo(100000);
    }
}