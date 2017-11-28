package com.kchmielewski.sda.concurrency.task11;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ListMeMoreThanEverTest {
    @Test
    public void listHasTheSameSizeAsParameterValue() throws Exception {
        assertThat(new ListMeMoreThanEver().createSquaresList(10000)).hasSize(10000);
    }

}