package com.euler;

import com.euler.util.PrimeGenerator;

import java.util.List;

public class Problem46 {
  public static void main(String[] args) {
    List<Integer> primes = PrimeGenerator.primesLessThan(10000);

    for (int n = 3; n <= 10000; n += 2) {
      boolean solutionFound = false;
      for (int p : primes) {
        double a = Math.sqrt((n - p) / 2);
        if (a == (int) a) {
          solutionFound = true;
//                    System.out.println(n + " = " + p + " + 2x" + (int) a + "^2");
          break;
        }
      }

      if (!solutionFound) {
        System.out.println(n);
      }
    }
  }
}
