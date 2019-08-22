package com.mckenzie;

import org.junit.Assert;
import org.junit.Test;

public class FactorialTest {

    private final Factorial fac = new Factorial();

    @Test
    public void test1() {
        Assert.assertEquals(fac.factorial(1), (Integer)1);
        Assert.assertEquals(fac.factorial(2), (Integer)2);
        Assert.assertEquals(fac.factorial(3), (Integer)6);
        Assert.assertEquals(fac.factorial(4), (Integer)24);
        Assert.assertEquals(fac.factorial(5), (Integer)120);
        Assert.assertEquals(fac.factorial(6), (Integer)720);
        Assert.assertEquals(fac.factorial(7), (Integer)5040);
    }
}