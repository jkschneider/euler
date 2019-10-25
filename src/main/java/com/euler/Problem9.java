package com.euler;

/**
 * Sieve of Erastosthenes
 *
 * @author Schneider
 */
public class Problem9 {
  static final int N = 5000000;

  public static void main(String[] args) {
    long start = System.currentTimeMillis();

    long sum = 3;

    boolean sieve[] = new boolean[N + 1];
    for (int i = 0; i < N + 1; i++)
      sieve[i] = true;

    for (int i = 3; i < N / 2; i += 2 /* all evens are obviously not prime */) {
      if (sieve[i]) {
        if (i > 2000000) {
          System.out.println("Time to complete: " + (System.currentTimeMillis() - start) + " ms");
          System.out.println("Sum: " + sum);
          return;
        }

        sum += i;

        long j = 2;
        while (j * i <= N)
          sieve[(int) (j++ * i)] = false;
      }
    }


  }
}
