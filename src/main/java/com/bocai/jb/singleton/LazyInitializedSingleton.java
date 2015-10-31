package com.bocai.jb.singleton;

public class LazyInitializedSingleton implements SelfIntroduce {
    private static LazyInitializedSingleton instance;

    private LazyInitializedSingleton() {
    }

    public static LazyInitializedSingleton getInstance() {
        if (LazyInitializedSingleton.instance == null) {
            LazyInitializedSingleton.instance = new LazyInitializedSingleton();
        }
        return LazyInitializedSingleton.instance;
    }

    @Override
    public void speak() {
        System.out.println("I'm LazyInitializedSingleton, compared to EagerInitializedSingleton, I'll create the instance when you use it the first time.");
        System.out.println("However I'm not designed for situation with multiple threads.");
        System.out.println();
    }
}
