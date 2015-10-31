package com.bocai.jb.singleton;

public class BillPughSingleton implements SelfIntroduce {
    private BillPughSingleton() {
    }

    private static class SingletonHelper {
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    public static BillPughSingleton getInstance() {
        return SingletonHelper.INSTANCE;
    }

    @Override
    public void speak() {
        System.out.println("I'm BillPughSingleton, compared to ThreadSafeSingleton, I cleverly dealt with the issue of synchronized or double checked locking");
        System.out.println();
    }
}
