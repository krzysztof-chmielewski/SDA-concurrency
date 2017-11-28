package com.kchmielewski.sda.concurrency.task07;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SynchronizeMyMethodTest {
    @Test
    public void thisMayActuallyWorkThisTime() throws Exception {
        assertThat(new SynchronizeMyMethod().incrementMeALot(100000)).isEqualTo(100000);
    }
}