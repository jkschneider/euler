package com.euler.p29;

import java.util.HashSet;
import java.util.Set;

public class Problem29 {
    public static void main(String[] args) {
        Set<Double> distinctTerms = new HashSet<Double>();
        for(int a = 2; a <= 100; a++)
            for(int b = 2; b <= 100; b++)
                distinctTerms.add(Math.pow(a,b));
        System.out.println(distinctTerms.size());
    }
}
