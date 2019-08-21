package com.mckenzie;

import java.util.*;
import java.util.stream.Collectors;

public class Pairs {

    /**
     * Return all pairs of distinct elements that sum to the desired total.
     * You cannot use the same element in both properties of a pair, e.g. findArrayPairSums({1, 4}, 8) should not return (4,4).
     * If the same number is repeated, you can use them to form a pair, e.g. findArrayPairSums({4,4}, 8) should return (4,4).
     * You should not return equivalent pairs, e.g. findArrayPairSums({1,7},8) should only return either (1,7) or (7,1) but not both.
     */
    public static Collection<Pair> findArrayPairSums(int[] numbers, int desiredTotal) {
        List<Integer> pairList = Arrays.stream(numbers).boxed().collect(Collectors.toList());
        ArrayList<Pair> results = new ArrayList<Pair>();

        while (pairList.size() > 0) {
            Iterator<Integer> iter = pairList.iterator();
            Integer val = iter.next();
            iter.remove();
            while (iter.hasNext()) {
                Integer pairVal = iter.next();
                if (pairVal + val == desiredTotal) {
                    iter.remove();
                    Pair resultPair = new Pair ( val, pairVal );
                    results.add(resultPair);
                    break;
                }
            }
        }

        return results;
    }

    public static class Pair {

        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        public String toString() {
            return String.format("(%s,%s)", first, second);
        }
    }

}
