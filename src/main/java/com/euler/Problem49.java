package com.euler;

import com.euler.util.PrimeGenerator;

import java.util.*;

public class Problem49 {
  public static void main(String[] args) {
    List<Integer> primes = PrimeGenerator.primesLessThan(10000);
    while (true) {
      if (primes.get(0) < 1000)
        primes.remove(0);
      else
        break;
    }

    Map<String, List<Integer>> primePermutBuckets = new HashMap<String, List<Integer>>();
    for (Integer prime : primes) {
      String primeSorted = sortString(prime.toString());
      List<Integer> primesInBucket = primePermutBuckets.get(primeSorted);

      if (primesInBucket == null) {
        primesInBucket = new ArrayList<Integer>();
        primePermutBuckets.put(primeSorted, primesInBucket);
      }

      primesInBucket.add(prime);
    }


    for (List<Integer> primeBucket : primePermutBuckets.values()) {
      int startIndex = 0;
      int diff = 0;

      for (int i = 1; i < primeBucket.size(); i++) {
        int curDiff = primeBucket.get(i) - primeBucket.get(i - 1);
        if (diff != curDiff) {
          startIndex = i - 1;
          diff = curDiff;
        }

        if (i - startIndex == 2) {
          System.out.println(primeBucket + " with diff " + diff);
        }
      }
    }
  }

  public static String sortString(String s) {
    char[] chars = s.toCharArray();
    Arrays.sort(chars);
    return new String(chars);
  }
}
