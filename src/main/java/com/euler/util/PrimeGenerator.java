package com.euler.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PrimeGenerator {
  public static List<Integer> primesLessThan(final int N) {
    List<Integer> primes = new ArrayList<>();

    boolean[] sieve = new boolean[N];
    for (int i = 0; i < N; i++)
      sieve[i] = true;

    for (int i = 2; i < N; i++) {
      if (sieve[i]) {
        primes.add(i);

        int j = 2;
        while (j * i < N)
          sieve[j++ * i] = false;
      }
    }

    return primes;
  }

  public static Set<Integer> primeSetLessThan(final int N) {
    Set<Integer> primes = new HashSet<>();

    boolean[] sieve = new boolean[N];
    for (int i = 0; i < N; i++)
      sieve[i] = true;

    for (int i = 2; i < N; i++) {
      if (sieve[i]) {
        primes.add(i);

        int j = 2;
        while (j * i < N)
          sieve[j++ * i] = false;
      }
    }

    return primes;
  }
}
