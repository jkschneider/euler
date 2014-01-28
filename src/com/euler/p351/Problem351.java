package com.euler.p351;

import java.util.Set;

import com.euler.PrimeGenerator;

public class Problem351 {
    public static void main(String[] args) {
        System.out.println("Generating primes...");
        Set<Integer> primes = PrimeGenerator.primeSetLessThan(100000000);
        
        int N = 1000000;
        long totalHiddenEvens = 0;
        long totalHiddenOdds = 0;
        
        System.out.println("Analyzing rows...");

        for(int n = 3; n <= N; n++) {
            if(n % 2 != 0) {
                if(!primes.contains(n)) {
                    for(int i = 3; i < n; i += 2)
                        if(n % i == 0 || !primes.contains(i))
                            totalHiddenOdds++;
                }
            }
        }
        
//        int primesLessThanN = 0;
//        for (int n = 3; n <= N; n++) {
//            if (n % 2 == 0) {
//                if((n/2) % 2 == 0) {
//                    totalHiddenEvens += (n/4)-1;
//                }
//                else {
//                    totalHiddenEvens += (n/4);
//                }
//            } 
//            else {
//                if(primes.contains(n)) 
//                    primesLessThanN++;
//                else {
//                    // the -1 is for 1, which is not considered a prime
//                    totalHiddenOdds +=  (N+1)/2 - primesLessThanN - 1;
//                }
////                totalHidden += (N/i-1)*((N-1)/2);
//            }
//        }
        
        long totalHidden = totalHiddenEvens + totalHiddenOdds;

        System.out.println("Evens: " + totalHiddenEvens + ", Odds: " + totalHiddenOdds);
        
        totalHidden = 12*totalHidden + 6*(N-1)+ 6*((N-2)/2);
        System.out.println(totalHidden);
    }
}

// for(N = 6; N <= 1000; N+=2) {
// Set<Float> uniqueAngles = new HashSet<Float>();
//long totalHidden = 0;
// for(float i = 2.0f; i <= N; i++) {
// float j = (i % 2 == 0) ? 2.0f : 1.0f;
// for(; j < i; j+=2)
// if(!uniqueAngles.add(j/i))
// totalHidden++;
// }
// System.out.println(12*totalHidden + 6*(N-1) + 6*((N-2)/2));
// }


// H(100)
// Unique angles: 1522
// 1028
