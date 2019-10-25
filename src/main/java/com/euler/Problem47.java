package com.euler;

import java.util.*;

class Problem47 {
  public static void main(String[] args) {
    final int distinctPrimeTarget = 4;
    final int consecutiveNTarget = 4;

    Queue<Set<PrimeFactor>> factors = new LinkedList<>();

    for (long n = 45000L; n < 1000000; n++) {
      factors.add(primeFactors(n));

      if (factors.size() > consecutiveNTarget) {
        factors.poll();
        Set<PrimeFactor> combinedFactors = new TreeSet<>();
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

  private static Set<PrimeFactor> primeFactors(Long N) {
    Set<PrimeFactor> factors = new TreeSet<>();

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

  static class PrimeFactor implements Comparable<PrimeFactor> {
    final long prime;
    int power = 1;

    PrimeFactor(long prime) {
      this.prime = prime;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      PrimeFactor that = (PrimeFactor) o;
      return prime == that.prime &&
        power == that.power;
    }

    @Override
    public int hashCode() {
      return Objects.hash(prime, power);
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
      return power - p0.power;
    }
  }
}
