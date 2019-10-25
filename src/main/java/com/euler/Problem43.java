package com.euler;

import com.euler.util.PermutationGenerator;

public class Problem43 {
  public static void main(String[] args) {
    PermutationGenerator g = new PermutationGenerator(10);

    int divisors[] = new int[]{2, 3, 5, 7, 11, 13, 17};

    long sum = 0;
    while (g.hasMore()) {
      String digits = g.getNextAsDigitString();
      if (digits.startsWith("0"))
        continue;

      boolean test = true;
      for (int i = 0; i < divisors.length; i++) {
        if (Integer.parseInt(digits.substring(1 + i, 4 + i)) % divisors[i] != 0) {
          test = false;
          break;
        }
      }
      if (test) {
        System.out.println(digits);
        sum += Long.parseLong(digits);
      }
    }

    System.out.println("Sum: " + sum);
  }
}
