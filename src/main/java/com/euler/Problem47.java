package com.euler;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

public class Problem47 {
  public static void main(String[] args) {
    final int distinctPrimeTarget = 4;
    final int consecutiveNTarget = 4;

    Queue<Set<PrimeFactor>> factors = new LinkedList<Set<PrimeFactor>>();

    for (long n = 45000L; n < 1000000; n++) {
      factors.add(primeFactors(n));

      if (factors.size() > consecutiveNTarget) {
        factors.poll();
        Set<PrimeFactor> combinedFactors = new TreeSet<PrimeFactor>();
        for (Set<PrimeFactor> factorSet : factors) {
          if (factorSet.size() != distinctPrimeTarget)
            break;
          combinedFactors.addAll(factorSet);
        }
        if (combinedFactors.size() == distinctPrimeTarget * consecutiveNTarget) {
          System.out.println("Last in consecutive set: " + n);
          System.out.println(combinedFactors);
          return;
        }
      }
    }
  }

  public static Set<PrimeFactor> primeFactors(Long N) {
    Set<PrimeFactor> factors = new TreeSet<PrimeFactor>();

    for (long i = 2L; i <= N / 2; i++) {
      if (N % i == 0) {
        boolean isComposite = false;
        for (PrimeFactor factor : factors) {
          if (i % factor.prime == 0) {
            factor.power++;
            isComposite = true;
            break;
          }
        }
        if (!isComposite)
          factors.add(new PrimeFactor(i));
      }
    }

    return factors;
  }

  public static class PrimeFactor implements Comparable<PrimeFactor> {
    public long prime;
    public int power = 1;

    public PrimeFactor(long prime) {
      this.prime = prime;
    }

    @Override
    public boolean equals(Object obj) {
      PrimeFactor other = (PrimeFactor) obj;
      if (power != other.power)
        return false;
      if (prime != other.prime)
        return false;
      return true;
    }

    @Override
    public String toString() {
      return (power == 1) ? Long.toString(prime) : prime + "^" + power;
    }

    @Override
    public int compareTo(PrimeFactor p0) {
      int primeDiff = (int) (prime - p0.prime);
      if (primeDiff != 0)
        return primeDiff;
      return (int) (power - p0.power);
    }
  }
}
