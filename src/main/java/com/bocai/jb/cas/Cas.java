package com.bocai.jb.cas;

import java.util.concurrent.atomic.AtomicInteger;

public class Cas {
    public void simpleIncrement() {
        final AtomicInteger atomicInteger = new AtomicInteger(20151008);
        atomicInteger.incrementAndGet();
        System.out.println(atomicInteger);
    }
}
