package com.bocai.jb.singleton;

public class ThreadSafeSingleton implements SelfIntroduce {
    private static ThreadSafeSingleton instance;

    private ThreadSafeSingleton() {
    }

    public static synchronized ThreadSafeSingleton getInstance() {
        if (ThreadSafeSingleton.instance == null) {
            ThreadSafeSingleton.instance = new ThreadSafeSingleton();
        }
        return ThreadSafeSingleton.instance;
    }

    public static ThreadSafeSingleton getInstanceUsingDoubleLocking() {
        if (ThreadSafeSingleton.instance == null) {
            synchronized (ThreadSafeSingleton.class) {
                if (ThreadSafeSingleton.instance == null) {
                    ThreadSafeSingleton.instance = new ThreadSafeSingleton();
                }
            }
        }
        return ThreadSafeSingleton.instance;
    }

    @Override
    public void speak() {
        System.out.println("I'm ThreadSafeSingleton, compared to EagerInitializedSingleton, I can handle situation with multiple threads.");
        System.out.println("I would like you to call me by getInstanceUsingDoubleLocking other than getInstance, which provides a better performance.");
        System.out.println();
    }

}
