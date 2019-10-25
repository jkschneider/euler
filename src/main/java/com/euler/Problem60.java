package com.euler;

import com.euler.util.PrimeGenerator;

import java.math.BigInteger;
import java.util.List;

public class Problem60 {
  static int MAX_PRIME_SIEVE = 1000000;

  static List<Integer> primes = PrimeGenerator.primesLessThan(MAX_PRIME_SIEVE);
  static List<Integer> testPrimes = PrimeGenerator.primesLessThan(5000);

  static int minSum = Integer.MAX_VALUE;
  static String minSumNums = "NONE FOUND";

  public static void main(String[] args) {
    int N = 4;
    int selections[] = new int[N];
    testConcatsRecurse(selections, N, 1, 0);

    System.out.println(minSum);
    System.out.println(minSumNums);
  }

  private static final void testConcatsRecurse(int[] selected, int initialLevel, int level, int priorLevelPos) {
    pTest:
    for (int p = priorLevelPos + 1; p < testPrimes.size() - initialLevel + level; p++) {
      selected[level - 1] = testPrimes.get(p);
      for (int i = 0; i < level - 1; i++)
        if (testConcat(selected[i], selected[level - 1])) {
          continue pTest;
        }

      if (level == initialLevel) {
        int sum = 0;
        String sumNums = "";
        for (int pSelect : selected) {
          sum += pSelect;
          sumNums += pSelect + " ";
        }
        System.out.println("tested: " + sumNums);

        if (minSum > sum) {
          minSum = sum;
          minSumNums = sumNums;
        }
      }

      if (level < initialLevel)
        testConcatsRecurse(selected, initialLevel, level + 1, p);
    }
  }

  public static boolean testConcat(int p1, int p2) {
    int concat1 = Integer.parseInt(p1 + "" + p2);
    int concat2 = Integer.parseInt(p2 + "" + p1);

    boolean concat1Compos = (concat1 < MAX_PRIME_SIEVE) ? !primes.contains(concat1) : !BigInteger.valueOf(concat1).isProbablePrime(3);
    boolean concat2Compos = (concat2 < MAX_PRIME_SIEVE) ? !primes.contains(concat2) : !BigInteger.valueOf(concat2).isProbablePrime(3);

    return !concat1Compos && !concat2Compos;
  }
}
