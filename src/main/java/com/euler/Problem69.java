package com.euler;

import java.util.HashMap;
import java.util.Map;

import static com.euler.util.MathExt.gcd;
import static com.euler.util.PrimeTest.prime;

class Problem69 {
  private final int N = 1000000;

  private final Map<Integer, Integer> totientCache = new HashMap<>();

  private int totient(int n) {
    if (n == 1 || n == 2) return 1;
    Integer totient = totientCache.get(n);

    if (totient == null) {
      if (n % 2 == 0) {
        if (n / 2 % 2 == 0)
          totient = 2 * totient(n / 2);
        else
          totient = totient(n / 2);
      } else if (prime(n))
        totient = n - 1;
      else {
        // phi(i*j) = phi(i)*phi(j)*(d/phi(d)) where d = gcd(i,j)
        int i = firstFactor(n);
        int j = n / i;
        int d = (int) gcd(i, j);
        totient = (totient(i) * totient(j) * d) / totient(d);
      }

      totientCache.put(n, totient);
    }
    return totient;
  }

  private int firstFactor(int n) {
    for (int i = 2; i <= Math.sqrt(n); i++)
      if (n % i == 0)
        return i;
    return n;
  }

  private void run() {
    int maxN = 0;
    double max = 0;

    for (int n = 1; n <= N; n++) {
      double totN = totient(n);
      if (n / totN > max) {
        max = n / totN;
        maxN = n;
      }
    }

    System.out.println("solution = " + maxN);
  }

  public static void main(String[] args) {
    new Problem69().run();
  }
}