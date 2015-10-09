package com.bocai.jb.concurrent;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;

public class Cas {
    public void simpleIncrement() {
        final AtomicInteger atomicInteger = new AtomicInteger(20151008);
        atomicInteger.incrementAndGet();
        System.out.println(atomicInteger);
    }

    static int value = 0;

    public void compareSynchronizedAndAtomicAndReentrantLock(final int calcCount) {
        Preconditions.checkArgument(calcCount > 0);

        long startTime = 0, endTime = 0;

        final ExecutorService executorService = Executors.newFixedThreadPool(2);
        final List<Future<Void>> futures = Lists.newArrayList();

        Cas.value = 0;
        final Object lock1 = new Object();
        startTime = System.currentTimeMillis();
        for (int i = 0; i < calcCount; i++) {
            futures.add(executorService.submit(new Callable<Void>() {
                @Override
                public Void call() throws Exception {
                    synchronized (lock1) {
                        ++Cas.value;
                    }
                    return null;
                }
            }));
        }
        for (final Future<Void> future : futures) {
            try {
                future.get();
            } catch (final Exception e) {
            }
        }
        endTime = System.currentTimeMillis();
        System.out.println(String.format("normal ++int %d times cost %d ms from %d to %d, value is %d", calcCount, endTime - startTime, startTime, endTime, Cas.value));

        final AtomicInteger atomicInteger1 = new AtomicInteger(0);
        startTime = System.currentTimeMillis();
        for (int i = 0; i < calcCount; i++) {
            futures.add(executorService.submit(new Callable<Void>() {
                @Override
                public Void call() throws Exception {
                    atomicInteger1.incrementAndGet();
                    return null;
                }
            }));
        }
        for (final Future<Void> future : futures) {
            try {
                future.get();
            } catch (final Exception e) {
            }
        }
        endTime = System.currentTimeMillis();
        System.out.println(String.format("AtomicInteger cas %d times cost %d ms from %d to %d, atomicInteger is %d", calcCount, endTime - startTime, startTime, endTime, atomicInteger1.intValue()));

        Cas.value = 0;
        final ReentrantLock lock = new ReentrantLock();
        startTime = System.currentTimeMillis();
        for (int i = 0; i < calcCount; i++) {
            futures.add(executorService.submit(new Callable<Void>() {
                @Override
                public Void call() throws Exception {
                    lock.lock();
                    try {
                        ++Cas.value;
                    } finally {
                        lock.unlock();
                    }
                    return null;
                }
            }));
        }
        for (final Future<Void> future : futures) {
            try {
                future.get();
            } catch (final Exception e) {
            }
        }
        endTime = System.currentTimeMillis();
        System.out.println(String.format("ReentrantLock %d times cost %d ms from %d to %d, value is %d", calcCount, endTime - startTime, startTime, endTime, Cas.value));

        executorService.shutdown();
    }
}
