package com.mckenzie;

import org.junit.Test;

public class TestPairs {

    @Test
    public void test1()
    {
        Pairs myPairs = new Pairs();

        // expected (in any order, not exhaustive): (0,8),(1,7),...,(9,-1)
        int[] numbers = {8, 0, 1, 7, 2, 4, 3, 3, 6, 5, 9, -1};
        System.out.println(myPairs.findArrayPairSums(numbers, 8));
    }
}
