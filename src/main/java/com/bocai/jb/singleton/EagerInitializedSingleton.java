package com.bocai.jb.singleton;

public class EagerInitializedSingleton implements SelfIntroduce {
    private static final EagerInitializedSingleton instance = new EagerInitializedSingleton();

    private EagerInitializedSingleton() {
    }

    public static EagerInitializedSingleton getInstance() {
        return EagerInitializedSingleton.instance;
    }

    @Override
    public void speak() {
        System.out.println("I'm EagerInitializedSingleton, I'll create the instance even you may not use it.");
        System.out.println();
    }

}
