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

    @Test
    public void testCompareAtomicAndSynchronized() {
        int calcCount = 1000000;
        this.cas.compareAtomicAndSynchronized(calcCount);
        System.out.println();

        calcCount *= 10;
        this.cas.compareAtomicAndSynchronized(calcCount);
        System.out.println();

        calcCount *= 10;
        this.cas.compareAtomicAndSynchronized(calcCount);
        System.out.println();

        // need to explain the following result in my local machine:

        // AtomicInteger cas 1000000 times cost 43 ms from 1444312152502 to 1444312152545, atomicInteger is 66355847,-737429448
        // normal ++int 1000000 times cost 59 ms from 1444312152547 to 1444312152606, normalInteger is -249900303,1729242971
        //
        // AtomicInteger cas 10000000 times cost 348 ms from 1444312152606 to 1444312152954, atomicInteger is -1054062048,-433214107
        // normal ++int 10000000 times cost 294 ms from 1444312152954 to 1444312153248, normalInteger is 1828511479,-1762278322
        //
        // AtomicInteger cas 100000000 times cost 3191 ms from 1444312153248 to 1444312156439, atomicInteger is -991743484,-1318598102
        // normal ++int 100000000 times cost 3194 ms from 1444312156440 to 1444312159634, normalInteger is 1975706487,1942196291

        // There maybe exists optimize in the os level. JUST GUESS.
    }

}
