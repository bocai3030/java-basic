package com.bocai.jb.jvm;

public class Jvm {
    public void finallyNotExecute() {
        System.out.println("normal code when finally block is executed:");
        try {
            Integer.parseInt("hello");
        } catch (final Exception ex) {
            System.out.println("I'm exception");
        } finally {
            System.out.println("I'm finally.");
        }

        System.out.println("abnormal code when finally block is NOT executed:");
        try {
            Integer.parseInt("hello");
        } catch (final Exception ex) {
            System.out.println("I'm exception");
            System.exit(0); // finally block will be executed WHEN JVM IS ALIVE
        } finally {
            System.out.println("I'm finally.");
        }
    }
}
