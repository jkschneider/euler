package com.euler;

import com.euler.util.PrimeGenerator;

import java.math.BigInteger;
import java.util.List;

class Problem60 {
  private static final int MAX_PRIME_SIEVE = 1000000;

  private static final List<Integer> primes = PrimeGenerator.primesLessThan(MAX_PRIME_SIEVE);
  private static final List<Integer> testPrimes = PrimeGenerator.primesLessThan(5000);

  private static int minSum = Integer.MAX_VALUE;
  private static String minSumNums = "NONE FOUND";

  public static void main(String[] args) {
    int N = 4;
    int[] selections = new int[N];
    testConcatsRecurse(selections, N, 1, 0);

    System.out.println(minSum);
    System.out.println(minSumNums);
  }

  private static void testConcatsRecurse(int[] selected, int initialLevel, int level, int priorLevelPos) {
    pTest:
    for (int p = priorLevelPos + 1; p < testPrimes.size() - initialLevel + level; p++) {
      selected[level - 1] = testPrimes.get(p);
      for (int i = 0; i < level - 1; i++)
        if (testConcat(selected[i], selected[level - 1])) {
          continue pTest;
        }

      if (level == initialLevel) {
        int sum = 0;
        StringBuilder sumNums = new StringBuilder();
        for (int pSelect : selected) {
          sum += pSelect;
          sumNums.append(pSelect).append(" ");
        }
        System.out.println("tested: " + sumNums);

        if (minSum > sum) {
          minSum = sum;
          minSumNums = sumNums.toString();
        }
      }

      if (level < initialLevel)
        testConcatsRecurse(selected, initialLevel, level + 1, p);
    }
  }

  private static boolean testConcat(int p1, int p2) {
    int concat1 = Integer.parseInt(p1 + "" + p2);
    int concat2 = Integer.parseInt(p2 + "" + p1);

    boolean concat1Compos = (concat1 < MAX_PRIME_SIEVE) ? !primes.contains(concat1) : !BigInteger.valueOf(concat1).isProbablePrime(3);
    boolean concat2Compos = (concat2 < MAX_PRIME_SIEVE) ? !primes.contains(concat2) : !BigInteger.valueOf(concat2).isProbablePrime(3);

    return !concat1Compos && !concat2Compos;
  }
}
