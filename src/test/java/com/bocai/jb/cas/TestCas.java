package com.bocai.jb.cas;

import org.junit.Before;
import org.junit.Test;

public class TestCas {
    private Cas cas;

    @Before
    public void before() {
        this.cas = new Cas();
    }

    @Test
    public void testSimpleIncrement() {
        this.cas.simpleIncrement();
    }

}
