package com.mckenzie;

import java.util.ArrayList;
import java.util.Vector;

public class StringSplit {

    public ArrayList<String> split(String str, int size) {
        ArrayList<String> result = new ArrayList<String>();

        if (str.isEmpty())
            return result;

        char[] chars = str.toCharArray();
        int eol = 0;
        int sol = 0;

        for (int i =0; i < chars.length; ++i) {
            if (chars[i] == ' ')
                eol = i;

                if (i-sol+1 > size) {

                result.add(str.substring(sol, eol));
                sol = eol+1;
            }
        }

        result.add(str.substring(sol, chars.length));

        return result;
    }
}
