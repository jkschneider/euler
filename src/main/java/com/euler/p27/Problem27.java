package com.euler.p27;

import java.util.List;

import com.euler.PrimeGenerator;

public class Problem27 {
    static final int N = 100;
    
    public static void main(String[] args) {
        int maxPrimes = 0;
        int maxA = -1000;
        int maxB = -1000;
        
        List<Integer> primes = PrimeGenerator.primesLessThan(N * N + 1000*N + 1000);
        
        for(int a = -999; a <= 999; a++) {
            for(int b = -999; b <= 999; b++) {
                int n;
                for(n = 0; n < N; n++) {
                    if(!primes.contains(n*n + (a*n) + b))
                        break;
                }
                
                if(n > maxPrimes) {
                    maxA = a;
                    maxB = b;
                    maxPrimes = n;
                }
            }
        }
        
        System.out.println("a: " + maxA + ", b: " + maxB + ", max primes: " + maxPrimes);
    }
}
