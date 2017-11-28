package com.kchmielewski.sda.concurrency.task12;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CacheMeNowTest {
    @Test
    public void sameParameterCallsReturnsSameObject() throws Exception {
        CacheMeNow cacheMeNow = new CacheMeNow();

        assertThat(cacheMeNow.createSquaresList(10000)).isSameAs(cacheMeNow.createSquaresList(10000));
    }

}