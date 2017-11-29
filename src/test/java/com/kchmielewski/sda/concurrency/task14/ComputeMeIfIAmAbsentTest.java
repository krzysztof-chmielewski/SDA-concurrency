package com.kchmielewski.sda.concurrency.task14;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ComputeMeIfIAmAbsentTest {
    @Test
    public void createsListOfGivenSize() throws Exception {
        ComputeMeIfIAmAbsent computeMe = new ComputeMeIfIAmAbsent();

        assertThat(computeMe.createSquaresList(10000)).hasSize(10000);
    }

    @Test
    public void sameParameterCallsReturnsSameObject() throws Exception {
        ComputeMeIfIAmAbsent computeMe = new ComputeMeIfIAmAbsent();

        assertThat(computeMe.createSquaresList(10000)).isSameAs(computeMe.createSquaresList(10000));
    }

}