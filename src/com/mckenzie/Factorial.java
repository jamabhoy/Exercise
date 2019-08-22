package com.mckenzie;

import java.util.HashMap;

class Factorial {

    static private HashMap<Integer, Integer> factorialCache = new HashMap<>(16);

    Factorial() { factorialCache.put(1,1); }

    Integer factorial(Integer number) {
        if (factorialCache.containsKey(number))
            return factorialCache.get(number);

        Integer result = number * factorial(number-1);
        factorialCache.put(number, result);
        return result;
    }
}
