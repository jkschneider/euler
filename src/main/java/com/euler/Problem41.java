package com.euler;

import com.euler.util.MathExt;
import com.euler.util.PrimeGenerator;

import java.util.List;

class Problem41 {
  public static void main(String[] args) {
    int maxPandigitalPrime = 1;

    List<Integer> primes = PrimeGenerator.primesLessThan(100000000);
    for (int prime : primes) {
      if (MathExt.isPandigital((long) prime)) {
        if (prime > maxPandigitalPrime) {
          System.out.println(prime);
          maxPandigitalPrime = prime;
        }
      }
    }

    System.out.println(maxPandigitalPrime);
  }
}
