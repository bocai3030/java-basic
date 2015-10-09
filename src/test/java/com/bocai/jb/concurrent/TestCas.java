package com.bocai.jb.concurrent;

import org.junit.Before;
import org.junit.Test;

import com.bocai.jb.concurrent.Cas;

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

    @Test
    public void testCompareSynchronizedAndAtomicAndReentrantLock() {
        int calcCount = 10000;
        this.cas.compareSynchronizedAndAtomicAndReentrantLock(calcCount);
        System.out.println();

        calcCount *= 10;
        this.cas.compareSynchronizedAndAtomicAndReentrantLock(calcCount);
        System.out.println();

        calcCount *= 10;
        this.cas.compareSynchronizedAndAtomicAndReentrantLock(calcCount);
        System.out.println();
    }

}
