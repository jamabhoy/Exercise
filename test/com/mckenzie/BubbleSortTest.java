package com.mckenzie;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class BubbleSortTest {

    @Test
    public void sortArray() {
        int arr[] = {12,5,7,1,19,4};
        int res[] = {1, 4, 5, 7, 12, 19};
        new BubbleSort().sortArray(arr);

        Assert.assertArrayEquals(res, arr);
    }
}