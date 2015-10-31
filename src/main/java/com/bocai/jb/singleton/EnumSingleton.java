package com.bocai.jb.singleton;

public enum EnumSingleton implements SelfIntroduce {
    INSTANCE;

    @Override
    public void speak() {
        System.out.println("I'm EnumSingleton. My flexibility is not enough, but I can prevent the damage of singleton from reflection.");
    }
}
