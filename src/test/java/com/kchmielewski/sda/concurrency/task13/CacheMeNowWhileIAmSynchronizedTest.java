package com.kchmielewski.sda.concurrency.task13;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CacheMeNowWhileIAmSynchronizedTest {
    @Test
    public void createsListOfGivenSize() throws Exception {
        CacheMeNowWhileIAmSynchronized cacheMeNow = new CacheMeNowWhileIAmSynchronized();

        assertThat(cacheMeNow.createSquaresList(10000)).hasSize(10000);
    }

    @Test
    public void sameParameterCallsReturnsSameObject() throws Exception {
        CacheMeNowWhileIAmSynchronized cacheMeNow = new CacheMeNowWhileIAmSynchronized();

        assertThat(cacheMeNow.createSquaresList(10000)).isSameAs(cacheMeNow.createSquaresList(10000));
    }
}