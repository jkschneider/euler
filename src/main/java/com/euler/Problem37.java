package com.euler;

import com.euler.util.PrimeGenerator;

import java.util.List;

class Problem37 {
  public static void main(String[] args) {
    int sum = 0;

    List<Integer> primes = PrimeGenerator.primesLessThan(1000000);
    for (Integer prime : primes) {
      if (prime < 10)
        continue;

      String primeStr = prime.toString();
      boolean isTruncatable = true;
      for (int i = 1; i < primeStr.length(); i++) {
        if (!primes.contains(Integer.parseInt(primeStr.substring(i))) ||
          !primes.contains(Integer.parseInt(primeStr.substring(0, primeStr.length() - i)))) {
          isTruncatable = false;
          break;
        }
      }

      if (isTruncatable) {
        System.out.println(prime);
        sum += prime;
      }
    }

    System.out.println("Sum: " + sum);
  }
}
