package com.bocai.jb.jvm;

import org.junit.Before;
import org.junit.Test;

public class TestJvm {
    private Jvm jvm;

    @Before
    public void before() {
        this.jvm = new Jvm();
    }

    @Test
    public void testFinallyNotExecute() {
        this.jvm.finallyNotExecute();
    }

}
