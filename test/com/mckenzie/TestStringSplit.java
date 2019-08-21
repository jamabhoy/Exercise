package com.mckenzie;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class TestStringSplit {

    StringSplit ss = new StringSplit();

    @Test
    public void test1() {
        // input "The last man standing is here", 10
        // output "The last", "man", "standing", "is here"

        ArrayList<String> res = ss.split("The last man standing is here", 10);

        Assert.assertEquals(Arrays.asList("The last", "man", "standing", "is here"), res) ;
    }

    @Test
    public void test2() {
        // input "", 10
        // output "The last", "man", "standing", "is here"

        ArrayList<String> res = ss.split("", 10);

        Assert.assertEquals(Arrays.asList(), res) ;
    }

    @Test
    public void test3() {
        // input "The", 10
        // output "The"

        ArrayList<String> res = ss.split("The", 10);

        Assert.assertEquals(Arrays.asList("The"), res) ;
    }

    @Test
    public void test4() {
        // input "The man was warm", 7
        // output "The man", "was", "warm"

        ArrayList<String> res = ss.split("The man was warm", 7);

        Assert.assertEquals(Arrays.asList("The man", "was", "warm"), res) ;
    }

    @Test
    public void test5() {
        // input "The man was warm", 4
        // output "The", "man", "was"

        ArrayList<String> res = ss.split("The man was warm", 4);

        Assert.assertEquals(Arrays.asList("The", "man", "was", "warm"), res) ;
    }

    @Test
    public void test6() {
        // input "The man was warm", 4
        // output "The", "man", "was"

        ArrayList<String> res = ss.split("1234 1 34 warm", 4);

        Assert.assertEquals(Arrays.asList("1234", "1 34", "warm"), res) ;
    }
}
