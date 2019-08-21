package com.mckenzie;

import org.junit.Test;

public class FactorialTest {

    private final Factorial fac = new Factorial();

    @Test
    public void test1() {
        for (int i=1; i<=5; ++i) {
            System.out.println(fac.factorial(i));
        }
    }
}