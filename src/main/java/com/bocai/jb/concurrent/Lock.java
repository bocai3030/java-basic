package com.bocai.jb.concurrent;

import java.util.concurrent.locks.LockSupport;

/**
 * 本类改编自http://www.cnblogs.com/skywang12345/p/3505784.html
 */
public class Lock {
    static class ThreadA extends Thread {
        public ThreadA(final String name) {
            super(name);
        }

        @Override
        public void run() {
            synchronized (this) { // 通过synchronized(this)获取“当前对象的同步锁”
                System.out.println(Thread.currentThread().getName() + " wakup others");
                this.notify(); // 唤醒“当前对象上的等待线程”
            }
        }
    }

    public void usingWait() {
        final ThreadA ta = new ThreadA("ta");

        synchronized (ta) { // 通过synchronized(ta)获取“对象ta的同步锁”
            try {
                System.out.println(Thread.currentThread().getName() + " start ta");
                ta.start();

                System.out.println(Thread.currentThread().getName() + " block");
                // 主线程等待
                ta.wait();

                System.out.println(Thread.currentThread().getName() + " continue");
            } catch (final InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static Thread mainThread;

    static class ThreadB extends Thread {
        public ThreadB(final String name) {
            super(name);
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " wakup others");
            // 唤醒“主线程”
            LockSupport.unpark(Lock.mainThread);
        }
    }

    public void usingPark(final boolean sleepAfterStart) {
        final ThreadB tb = new ThreadB("tb");

        // 获取主线程
        Lock.mainThread = Thread.currentThread();

        System.out.println(Thread.currentThread().getName() + " start tb");
        tb.start();

        /**
         * see http://www.docjar.com/html/api/sun/misc/Unsafe.java.html<br>
         * park method will unblock the given thread blocked on <tt>park</tt>,<br>
         * or, if it is not blocked, cause the subsequent call to <tt>park</tt> not to block.
         */
        if (sleepAfterStart) {
            try {
                Thread.sleep(2000);
            } catch (final InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(Thread.currentThread().getName() + " block");
        // 主线程阻塞
        LockSupport.park(Lock.mainThread);

        System.out.println(Thread.currentThread().getName() + " continue");
    }
}
