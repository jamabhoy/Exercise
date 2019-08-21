package com.mckenzie;

import org.junit.Test;

// Series 1 1 2 3 5 8 13 21 34 55
public class TestFibonacci {
    private final Fib fib = new Fib();

    @Test
    public void test1() {
        for (int i=1; i<=11; ++i) {
            System.out.println(fib.fibonacci(i) + " ");
        }
    }

}
