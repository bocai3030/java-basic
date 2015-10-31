package com.bocai.jb.singleton;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;

public class TestSingleton {
    private final List<SelfIntroduce> singletonSelfIntroduceList = Lists.newArrayList();

    @Before
    public void before() {
        this.singletonSelfIntroduceList.add(EagerInitializedSingleton.getInstance());
        this.singletonSelfIntroduceList.add(LazyInitializedSingleton.getInstance());
        this.singletonSelfIntroduceList.add(ThreadSafeSingleton.getInstanceUsingDoubleLocking());
        this.singletonSelfIntroduceList.add(BillPughSingleton.getInstance());
        this.singletonSelfIntroduceList.add(EnumSingleton.INSTANCE);
    }

    @Test
    public void testSingletonSelfIntroduce() {
        for (int i = 0; i < this.singletonSelfIntroduceList.size(); i++) {
            this.singletonSelfIntroduceList.get(i).speak();
        }
    }

}
