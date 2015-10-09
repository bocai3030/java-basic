package com.bocai.jb.concurrent;

import org.junit.Before;
import org.junit.Test;

public class TestLock {
    private Lock lock;

    @Before
    public void before() {
        this.lock = new Lock();
    }

    @Test
    public void testWaitAndPark() {
        this.lock.usingWait();
        System.out.println();

        this.lock.usingPark(false);
        System.out.println();

        this.lock.usingPark(true);
    }

}
