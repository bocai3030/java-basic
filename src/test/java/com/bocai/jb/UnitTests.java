package com.bocai.jb;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.bocai.jb.concurrent.TestCas;
import com.bocai.jb.concurrent.TestLock;

@RunWith(Suite.class)
@SuiteClasses({ /* TestJvm.class, */TestCas.class, TestLock.class })
public class UnitTests {
    // run "mvn -Dtest=UnitTests test" or "mvn -Dtest=YourTestClassName test" on cmd
}
