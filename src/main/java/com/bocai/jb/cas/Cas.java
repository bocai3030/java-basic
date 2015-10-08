package com.bocai.jb.cas;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import com.google.common.base.Preconditions;

public class Cas {
    public void simpleIncrement() {
        final AtomicInteger atomicInteger = new AtomicInteger(20151008);
        atomicInteger.incrementAndGet();
        System.out.println(atomicInteger);
    }

    public void compareAtomicAndSynchronized(final int calcCount) {
        Preconditions.checkArgument(calcCount > 0);

        long startTime = 0, endTime = 0;
        final Random random = new Random(System.currentTimeMillis());

        final AtomicInteger atomicInteger1 = new AtomicInteger(0);
        final AtomicInteger atomicInteger2 = new AtomicInteger(0);
        startTime = System.currentTimeMillis();
        for (int i = 0; i < calcCount; i++) {
            atomicInteger1.addAndGet(random.nextInt());
            atomicInteger2.addAndGet(random.nextInt());
        }
        endTime = System.currentTimeMillis();
        System.out
                .println(String.format("AtomicInteger cas %d times cost %d ms from %d to %d, atomicInteger is %d,%d", calcCount, endTime - startTime, startTime, endTime, atomicInteger1.intValue(), atomicInteger2
                        .intValue()));

        int normalInteger1 = 0;
        int normalInteger2 = 0;
        final Object lock1 = new Object();
        final Object lock2 = new Object();
        startTime = System.currentTimeMillis();
        for (int i = 0; i < calcCount; i++) {
            synchronized (lock1) {
                normalInteger1 += random.nextInt();
            }
            synchronized (lock2) {
                normalInteger2 += random.nextInt();
            }
        }
        endTime = System.currentTimeMillis();
        System.out.println(String.format("normal ++int %d times cost %d ms from %d to %d, normalInteger is %d,%d", calcCount, endTime - startTime, startTime, endTime, normalInteger1, normalInteger2));

    }
}
