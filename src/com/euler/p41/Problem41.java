package com.euler.p41;

import java.util.List;

import com.euler.MathExt;
import com.euler.PrimeGenerator;

public class Problem41 {
    public static void main(String[] args) {
        Integer maxPandigitalPrime = 1;
        
        List<Integer> primes = PrimeGenerator.primesLessThan(100000000);
        for(int prime : primes) {
            if(MathExt.isPandigital((long) prime)) {
                if(prime > maxPandigitalPrime) {
                    System.out.println(prime);
                    maxPandigitalPrime = prime;
                }
            }
        }
        
        System.out.println(maxPandigitalPrime);
    }
}
