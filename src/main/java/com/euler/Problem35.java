package com.euler;

import com.euler.util.PrimeGenerator;

import java.util.ArrayList;
import java.util.List;

public class Problem35 {
  public static void main(String[] args) {
    List<Integer> primes = PrimeGenerator.primesLessThan(1000000);

    List<Integer> circular = new ArrayList<Integer>();

    for (Integer prime : primes) {
      String primeString = prime.toString();

      boolean isCircular = true;
      for (int i = 0; i < primeString.length() - 1; i++) {
        primeString = primeString.substring(1) + primeString.charAt(0);
        if (!primes.contains(Integer.parseInt(primeString))) {
          isCircular = false;
          break;
        }
      }

      if (isCircular) {
        circular.add(prime);
        System.out.println(prime);
      }
    }

    System.out.println(circular);
    System.out.println(circular.size());
  }
}
