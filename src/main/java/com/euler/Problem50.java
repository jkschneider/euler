package com.euler;

import com.euler.util.PrimeGenerator;

import java.util.List;

class Problem50 {
  public static void main(String[] args) {
    int answer = 0;
    int maxConsecutive = 0;

    List<Integer> primes = PrimeGenerator.primesLessThan(1000000);
    for (int i = 2; i < primes.size(); i++) {
      int prime = primes.get(i);

      for (int j = 0; j < i; j++) {
        int sum = 0;
        if (primes.get(j) > prime / 2)
          break;

        for (int k = j; k <= i; k++) {
          sum += primes.get(k);
          if (sum == prime) {
            if (k - j + 1 > maxConsecutive) {
              maxConsecutive = k - j + 1;
              answer = prime;
            }

            break;
          } else if (sum > prime)
            break;
        }
      }
    }

    System.out.println(answer + " with " + maxConsecutive + " terms");
  }
}
