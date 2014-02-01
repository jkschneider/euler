package com.euler;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactorGenerator {
    public static List<Integer> primeFactors(int number) {
        int n = number; 
        List<Integer> factors = new ArrayList<Integer>();
        for (int i = 2; i <= Math.sqrt(n); i++) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }
        return factors;
    }
}
