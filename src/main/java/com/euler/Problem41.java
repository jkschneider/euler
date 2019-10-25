package com.euler;

import com.euler.util.MathExt;
import com.euler.util.PrimeGenerator;

import java.util.List;

public class Problem41 {
  public static void main(String[] args) {
    Integer maxPandigitalPrime = 1;

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
