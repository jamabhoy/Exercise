package com.mckenzie;

import java.util.HashMap;

public class Fib {
    private final HashMap<Integer, Integer> fibNos = new HashMap<Integer, Integer>(4);

    public Fib() {
        fibNos.put(1, 1);
        fibNos.put(2, 1);
    }
    // Series 1 1 2 3 5 8 13 21 34 55
    public int fibonacci (int number) {
        if (fibNos.containsKey(number)) {
            return fibNos.get(number);
        }

        int value = fibonacci(number-1) + fibonacci(number-2);
        fibNos.put(number, value);
        return value;
    }
}
